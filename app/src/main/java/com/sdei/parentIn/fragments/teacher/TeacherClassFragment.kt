package com.sdei.parentIn.fragments.teacher

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Build
import android.view.View
import androidx.annotation.NonNull
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdei.parentIn.R
import com.sdei.parentIn.adapters.TeacherClassAdapter
import com.sdei.parentIn.dialog.ExportCsvFileDialog
import com.sdei.parentIn.dialog.TeacherAddChildDialog
import com.sdei.parentIn.fragments.BaseFragment
import com.sdei.parentIn.interfaces.InterConst
import com.sdei.parentIn.interfaces.InterfacesCall
import com.sdei.parentIn.model.BaseModel
import com.sdei.parentIn.model.ClassModel
import com.sdei.parentIn.utils.*
import com.sdei.parentIn.viewModel.teacher.TeacherClassViewModel
import com.wajahatkarim3.easyvalidation.core.view_ktx.validEmail
import kotlinx.android.synthetic.main.fragment_teacher_class.*

/**
 * Fragment to show class mDialoglist
 */
class TeacherClassFragment : BaseFragment<TeacherClassViewModel>(), View.OnClickListener {
    private val WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 54654
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnAddStuManually -> {
                mDialog.showDialog()
            }

            R.id.btnExportStuList -> {
                exportDialog.showDialog()
            }
        }

    }

    lateinit var mDialog: TeacherAddChildDialog
    lateinit var exportDialog: ExportCsvFileDialog

    var classList = ArrayList<ClassModel.DataBean>()
    lateinit var classAdapter: TeacherClassAdapter
    override val layoutId: Int
        get() = R.layout.fragment_teacher_class
    override val viewModel: TeacherClassViewModel
        get() = ViewModelProviders.of(this).get(TeacherClassViewModel::class.java)

    override fun onCreateStuff() {
        setClassListAdapter()
        if (mContext.connectedToInternet(rvTeacherClass)) {
            mContext.showProgess()
            mViewModel!!.hitClassListByTeacherApi(getAppPref().getString(InterConst.ID)!!)
        }
        // get response
        mViewModel!!.getClass().observe(this, Observer<ClassModel> { mData ->
            if (mData != null && mContext.responseHandler(mData.statusCode, mData.message)) {
                classList = mData.data
                setClassListAdapter()
            }
        })

        //add Child manually
        mDialog = TeacherAddChildDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_teacher_add_child) { mData ->
            if (mData.child!!.firstName!!.isEmpty()) {
                mContext.showToast(getString(R.string.errorFirstName))
            } else if (mData.child!!.lastName!!.isEmpty()) {
                mContext.showToast(getString(R.string.errorLastName))
            } else if (mData.child!!.birthDate!!.isEmpty()) {
                mContext.showToast(getString(R.string.errorBirthday))
            } else if (mData.child!!.verificationCard!!.isEmpty()) {
                mContext.showToast(getString(R.string.errorIdentification))
            } else if (mData.firstName!!.isEmpty()) {
                mContext.showToast(getString(R.string.errorFirstName))
            } else if (mData.lastName!!.isEmpty()) {
                mContext.showToast(getString(R.string.errorLastName))
            } else if (mData.emailAddress!!.isEmpty()) {
                mContext.showToast(getString(R.string.errorEmail))
            } else if (!mData.emailAddress!!.validEmail()) {
                mContext.showToast(getString(R.string.errorValidEmail))
            } else {
                if (mContext.connectedToInternet()) {
                    mContext.showProgess()
                    mViewModel!!.sendRedToAddStudent(mData)
                }
            }
        }

        // check add student status
        mViewModel!!.getAddStudentStatus().observe(this, Observer<BaseModel> { mData ->
            if (mData != null && mContext.responseHandler(mData.statusCode, mData.message)) {
                mDialog.dismissDialog()
                mViewModel!!.hitClassListByTeacherApi(getAppPref().getString(InterConst.ID)!!)
            }
        })


        // export  csv dialog
        exportDialog = ExportCsvFileDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_export_csv, InterfacesCall.BtnClick {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), WRITE_EXTERNAL_STORAGE_REQUEST_CODE)
            }else{
                DirectoryHelper.createDirectory(mContext)
                makeReqForCSV()
            }

        })


    }

    private fun makeReqForCSV() {
        if (mContext.connectedToInternet(rvTeacherClass)) {
            viewModel.sendReqForCSVFile(getAppPref().getString(InterConst.ID)).observe(this, Observer { mData ->
                if (mData != null && mContext.responseHandler(mData.statusCode, mData.message)) {
                    exportDialog.dismissDialog()
                    mContext.startService(DownloadFileService.getDownloadService(mContext,mData.data.toString(), DirectoryHelper.ROOT_DIRECTORY_NAME+"/File"))
                }
            })
        }
    }

    private fun setClassListAdapter() {
        rvTeacherClass.layoutManager = LinearLayoutManager(mContext)
        classAdapter = TeacherClassAdapter(mContext, classList)
        rvTeacherClass.adapter = classAdapter
    }

    override fun initListeners() {
        btnAddStuManually.setOnClickListener(this)
        btnExportStuList.setOnClickListener(this)
    }


    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var instance: TeacherClassFragment

        fun newInstance(): TeacherClassFragment {
            instance = TeacherClassFragment()
            return instance
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, @NonNull permissions: Array<String>, @NonNull grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == WRITE_EXTERNAL_STORAGE_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                DirectoryHelper.createDirectory(mContext)
                 makeReqForCSV()
        }
    }

}
