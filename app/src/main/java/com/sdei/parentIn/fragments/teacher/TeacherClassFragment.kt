package com.sdei.parentIn.fragments.teacher

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.afollestad.assent.Permission
import com.afollestad.assent.askForPermissions
import com.huxq17.download.DownloadConfig
import com.huxq17.download.Pump
import com.huxq17.download.message.DownloadListener
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
import kotlinx.android.synthetic.main.fragment_class.*

/**
 * Fragment to show class list
 */
class TeacherClassFragment : BaseFragment<TeacherClassViewModel>(), View.OnClickListener {
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

    private var progressDialog: ProgressDialog? = null
    lateinit var mDialog: TeacherAddChildDialog
    lateinit var exportDialog: ExportCsvFileDialog

    var classList = ArrayList<ClassModel.DataBean>()
    lateinit var classAdapter: TeacherClassAdapter
    override val layoutId: Int
        get() = R.layout.fragment_class
    override val viewModel: TeacherClassViewModel
        get() = ViewModelProviders.of(this).get(TeacherClassViewModel::class.java)

    override fun onCreateStuff() {
        DownloadConfig.newBuilder(mContext)
                //Optional,set the maximum number of tasks to run, default 3.
                .setMaxRunningTaskNum(2)
                //Optional,set the minimum available storage space size for downloading to avoid insufficient storage space during downloading, default is 4kb.
                //.setMinUsableStorageSpace(4*1024L)
                .build()
        setClassListAdapter()
        mContext.showProgess()
        initProgressDialog()

        // make request
        mViewModel!!.hitClassListByTeacherApi(getAppPref().getString(InterConst.ID)!!)

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
            if (mContext.connectedToInternet()) {
                viewModel.sendReqForCSVFile(getAppPref().getString(InterConst.ID)).observe(this, Observer { mData ->
                    if (mData != null && mContext.responseHandler(mData.statusCode, mData.message)) {
                        mDialog.dismissDialog()
                        progressDialog!!.progress = 0
                        progressDialog!!.show()

                        Pump.newRequest(mData.data)
                                .listener(object : DownloadListener() {
                                    override fun onProgress(progress: Int) {
                                        super.onProgress(progress)
                                        progressDialog!!.progress = progress
                                    }

                                    override fun onSuccess() {
                                        super.onSuccess()
                                        progressDialog!!.dismiss()
                                        val filePath = downloadInfo.filePath
                                        askForPermissions(Permission.WRITE_EXTERNAL_STORAGE) {

                                        }
                                    }
                                }).submit()
                    }
                })


            }
        })


    }

    private fun initProgressDialog() {
        progressDialog = ProgressDialog(mContext)
        progressDialog!!.setTitle("Downloading")
        progressDialog!!.progress = 0
        progressDialog!!.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
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

}
