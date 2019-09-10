package com.sdei.parentIn.activities

import android.content.Context
import android.os.Build
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.afollestad.assent.Permission
import com.afollestad.assent.askForPermissions
import com.sdei.parentIn.R
import com.sdei.parentIn.dialog.DeleteAccountDialog
import com.sdei.parentIn.interfaces.InterConst
import com.sdei.parentIn.interfaces.InterfacesCall
import com.sdei.parentIn.utils.*
import com.sdei.parentIn.viewModel.SettingsViewModel
import kotlinx.android.synthetic.main.activity_setting.*

class SettingsActivity : BaseActivity<SettingsViewModel>(), View.OnClickListener {

    lateinit var mDialog: DeleteAccountDialog
    override val layoutId: Int
        get() = R.layout.activity_setting
    override val viewModel: SettingsViewModel
        get() = ViewModelProviders.of(this).get(SettingsViewModel::class.java)
    override val context: Context
        get() = this@SettingsActivity

    override fun onCreate() {
        if (getAppPref().getInt(InterConst.ROLE_ID) == InterConst.ROLE_PARENT) {
            cvParentsInfo.visibility = View.VISIBLE
            cvStuInfo.visibility = View.VISIBLE
            // For Teacher
            cvExportList.visibility = View.GONE
            cvHelpSupport.visibility = View.GONE
            cvTeacherInfo.visibility = View.GONE
        } else {
            cvParentsInfo.visibility = View.GONE
            cvStuInfo.visibility = View.GONE
            // For Teacher
            cvExportList.visibility = View.VISIBLE
            cvHelpSupport.visibility = View.VISIBLE
            cvTeacherInfo.visibility = View.VISIBLE
        }
    }

    override fun initListeners() {
        txtDeleteAccount.setOnClickListener(this)
        cvLogOut.setOnClickListener(this)
        cvExportList.setOnClickListener(this)
        cvHelpSupport.setOnClickListener(this)
        cvParentsInfo.setOnClickListener(this)
        cvTeacherInfo.setOnClickListener(this)
        cvStuInfo.setOnClickListener(this)
        btnBack.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.cvLogOut -> {
                logOut()
            }
            R.id.btnBack -> {
                finish()
            }
            R.id.cvTeacherInfo -> {
                //val intent = Intent(mContext, TeacherRegisterActivity::class.java)
                //intent.putExtra(InterConst.SETTINGS, InterConst.SETTINGS)
                //startActivity(intent)
            }
            R.id.cvExportList -> {
                if(Build.VERSION.SDK_INT >= 23){
                    askForPermissions(Permission.WRITE_EXTERNAL_STORAGE){
                      getCSVFile()
                  }
                }else{
                    getCSVFile()
                }

            }
            R.id.txtDeleteAccount ->{
             mDialog = DeleteAccountDialog(mContext, R.style.pullBottomfromTop, R.layout.delete_account,getString(R.string.eliminar_cuenta),getString(R.string.confirma_si_quieres_eliminar_tu_cuenta),InterfacesCall.BtnClick{

             })
             mDialog.showDialog()
            }
        }
    }

    private fun getCSVFile() {
        if (mContext.connectedToInternet(cvTeacherInfo)) {
            viewModel.sendReqForCSVFile(getAppPref().getString(InterConst.ID)).observe(this, Observer { mData ->
                if (mData != null && mContext.responseHandler(mData.statusCode, mData.message)) {
                    mContext.startService(DownloadFileService.getDownloadService(mContext, mData.data.toString(), DirectoryHelper.ROOT_DIRECTORY_NAME + "/File"))
                }
            })
        }
    }
}