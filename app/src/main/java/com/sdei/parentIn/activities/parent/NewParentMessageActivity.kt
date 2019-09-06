package com.sdei.parentIn.activities.parent

import `in`.mayanknagwanshi.imagepicker.ImageSelectActivity
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.text.TextUtils
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdei.parentIn.R
import com.sdei.parentIn.activities.BaseActivity
import com.sdei.parentIn.adapters.ParentMsgNameAddedAdapter
import com.sdei.parentIn.dialog.ParentMessageSelectNameDialog
import com.sdei.parentIn.dialog.ParentMessageSelectNameDialog.IndexClick
import com.sdei.parentIn.model.ChildModel
import com.sdei.parentIn.model.MessagesModel
import com.sdei.parentIn.utils.connectedToInternet
import com.sdei.parentIn.utils.responseHandler
import com.sdei.parentIn.utils.showAlertSnackBar
import com.sdei.parentIn.utils.showProgess
import com.sdei.parentIn.viewModel.parent.NewParentMessageViewModel
import kotlinx.android.synthetic.main.activity_new_message.*


class NewParentMessageActivity : BaseActivity<NewParentMessageViewModel>(), View.OnClickListener, ParentMsgNameAddedAdapter.ClickInterface {

    override fun deleteChild(pos: Int) {
        mNameList.removeAt(pos)
        setAddNameAdapter()
    }

    override val layoutId: Int
        get() = R.layout.activity_new_message
    override val viewModel: NewParentMessageViewModel
        get() = ViewModelProviders.of(this).get(NewParentMessageViewModel::class.java)
    override val context: Context
        get() = this@NewParentMessageActivity

    var mChildrenList = arrayListOf<ChildModel.DataBean>()
    var mNameList = arrayListOf<ChildModel.DataBean>()

    lateinit var mAddAdapter: ParentMsgNameAddedAdapter
    var filePath: String? = ""

    override fun onCreate() {
        setAddNameAdapter()

        mViewModel!!.getChildList().observe(this,
                Observer<ArrayList<ChildModel.DataBean>> { mData ->
                    if (mData != null) {
                        mChildrenList = mData
                    }
                })

        mViewModel!!.messageCreated().observe(this,
                Observer<MessagesModel> { mData ->
                    if (mData != null && responseHandler(mData.statusCode, mData.message)) {
                        finish()
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
            R.id.txtSubmit -> {
                if (mNameList.isEmpty()) {
                    showAlertSnackBar(imgAdd, getString(R.string.add_child_to_send_messages))

                    return
                } else if (edtMessage.text.trim().toString().isEmpty()) {
                    showAlertSnackBar(imgAdd, getString(R.string.please_enter_message_first))
                    return
                }
                if (connectedToInternet(txtSubmit)) {
                    val toId = arrayListOf<String>()
                    val toFrom = arrayListOf<String>()

                    for (i in 0 until mNameList.size) {
                        toId.add(mNameList[i].teacher!!)
                        toFrom.add(mNameList[i].teacherFirstName!! + mNameList[i].teacherLastName!!)
                    }
                    showProgess()
                    mViewModel!!.sendMessage(filePath!!,toId, toFrom, edtMessage.text.trim().toString())
                }
            }

            R.id.imgAdd -> {
                if (mChildrenList.isNotEmpty()) {
                    ParentMessageSelectNameDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_message_select_name,
                            mChildrenList,
                            object : IndexClick {
                                override fun clickIndex(pos: ChildModel.DataBean) {
                                    if (TextUtils.isEmpty(pos._id)) {
                                        mNameList.clear()
                                        mNameList.addAll(mChildrenList)
                                    } else {
                                        if (!mNameList.contains(pos)) {
                                            mNameList.add(pos)
                                        }
                                    }
                                    setAddNameAdapter()
                                }
                            }).show()
                } else {
                    showAlertSnackBar(imgAdd, getString(R.string.add_child_to_send_messages))
                }
            }

            R.id.layoutAttach -> {
                val intent = Intent(this, ImageSelectActivity::class.java)
                intent.putExtra(ImageSelectActivity.FLAG_COMPRESS, true)//default is true
                intent.putExtra(ImageSelectActivity.FLAG_CAMERA, true)//default is true
                intent.putExtra(ImageSelectActivity.FLAG_GALLERY, false)//default is true
                startActivityForResult(intent, 1213)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1213 && resultCode == Activity.RESULT_OK) {
            filePath = data!!.getStringExtra(ImageSelectActivity.RESULT_FILE_PATH)

            val selectedImage = BitmapFactory.decodeFile(filePath)
            if (selectedImage != null) {
                imgUploaded.visibility = View.VISIBLE
                imgViewAttach.visibility = View.GONE
                textView9.visibility = View.GONE
                imgUploaded.setImageBitmap(selectedImage)
            }
        }
    }


    private fun setAddNameAdapter() {
        if (mNameList.size >= 1) {
            imgAdd.visibility = View.GONE
        } else {
            imgAdd.visibility = View.VISIBLE
        }
        rvAddName.layoutManager = LinearLayoutManager(mContext)
        mAddAdapter = ParentMsgNameAddedAdapter(mContext, mNameList, this)
        rvAddName.adapter = mAddAdapter
    }


}
