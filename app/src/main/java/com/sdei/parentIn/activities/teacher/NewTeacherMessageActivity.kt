package com.sdei.parentIn.activities.teacher

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdei.parentIn.R

import com.sdei.parentIn.activities.BaseActivity
import com.sdei.parentIn.adapters.TeacherMsgNameAddedAdapter
import com.sdei.parentIn.dialog.TeacherMessageSelectNameDialog
import com.sdei.parentIn.model.ClassModel
import com.sdei.parentIn.utils.CameraHelper
import com.sdei.parentIn.utils.TAKE_PICTURE
import com.sdei.parentIn.viewModel.teacher.NewTeacherMessageViewModel
import kotlinx.android.synthetic.main.activity_new_message.*

class NewTeacherMessageActivity: BaseActivity<NewTeacherMessageViewModel>(), View.OnClickListener, TeacherMsgNameAddedAdapter.ClickInterface {
    val ALL_PERMISSION_GRANTED =100
    override fun deleteChild(pos: Int) {
        mNameList.removeAt(pos)
        setAddNameAdapter()
    }

    override val layoutId: Int
        get() = R.layout.activity_new_message

    override val viewModel: NewTeacherMessageViewModel
        get() = ViewModelProviders.of(this).get(NewTeacherMessageViewModel::class.java)

    override val context: Context
        get() = this@NewTeacherMessageActivity

    var mClassList = arrayListOf<ClassModel.DataBean>()
    var mNameList = arrayListOf<ClassModel.DataBean>()

    lateinit var mAddAdapter: TeacherMsgNameAddedAdapter

    override fun onCreate() {
        mViewModel!!.getClassList().observe(this,
                Observer<ArrayList<ClassModel.DataBean>> { mData ->
                    if (mData != null) {
                        mClassList = mData
                    }
                })
    }

    override fun initListeners() {
        btnBack.setOnClickListener(this)
        txtSubmit.setOnClickListener(this)
        imgAdd.setOnClickListener(this)
        layoutAttach.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.btnBack -> {
                finish()
            }

            R.id.imgAdd -> {
                TeacherMessageSelectNameDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_message_select_name,
                        mClassList,
                        object : TeacherMessageSelectNameDialog.IndexClick {
                            override fun clickIndex(pos: ClassModel.DataBean) {
                                if (TextUtils.isEmpty(pos._id)) {
                                    mNameList.clear()
                                    mNameList.addAll(mClassList)
                                } else {
                                    if (!mNameList.contains(pos)) {
                                        mNameList.add(pos)
                                    }
                                }
                                setAddNameAdapter()
                            }
                        }).show()
            }
            R.id.layoutAttach -> {

                captureImageForUpperVersion()
                /*if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                  captureImageForUpperVersion()
                }else{
                  //CameraHelper(this).takePicIfLowerVersion()
                }*/

            }
        }
    }

    private fun captureImageForUpperVersion() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            requestPermissions(arrayOf(Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE),ALL_PERMISSION_GRANTED)
        }else{
            CameraHelper(this).testCamera()
        }
    }


    private fun setAddNameAdapter() {
        rvAddName.layoutManager = LinearLayoutManager(mContext)
        mAddAdapter = TeacherMsgNameAddedAdapter(mContext, mNameList, this)
        rvAddName.adapter = mAddAdapter
    }
    // get  permission Result
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            ALL_PERMISSION_GRANTED -> if (grantResults.size > 0) {
                val cameraAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED
                val writeExternalAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED
               // val readExternalAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED
                if (cameraAccepted && writeExternalAccepted) {
                    CameraHelper(this).testCamera()
                }else{
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    // get camera Result
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == TAKE_PICTURE && resultCode == Activity.RESULT_OK ){
            //To get the File for further usage
            //val auxFile = File(CameraHelper(this).currentPhotoPath)
           // var bitmap: Bitmap = BitmapFactory.decodeFile(CameraHelper(this).currentPhotoPath)
           //  imgViewAttach.setImageBitmap(bitmap)

            imgViewAttach.setImageURI(Uri.parse(CameraHelper(this).currentPhotoPath))

        }
    }

}
