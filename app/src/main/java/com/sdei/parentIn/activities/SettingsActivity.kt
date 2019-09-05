package com.sdei.parentIn.activities


import android.content.Context
import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.interfaces.InterConst
import com.sdei.parentIn.utils.getAppPref
import com.sdei.parentIn.viewModel.BaseViewModel
import kotlinx.android.synthetic.main.activity_setting.*


class SettingsActivity : BaseActivity<BaseViewModel>(), View.OnClickListener {


    override val layoutId: Int
        get() = R.layout.activity_setting
    override val viewModel: BaseViewModel
        get() = ViewModelProviders.of(this).get(BaseViewModel::class.java)
    override val context: Context
        get() = this@SettingsActivity

    override fun onCreate() {

        if(getAppPref().getInt(InterConst.ROLE_ID) == InterConst.ROLE_PARENT){
          cvParentsInfo.visibility = View.VISIBLE
          cvStuInfo.visibility = View.VISIBLE
            // For Teacher
            cvExportList.visibility = View.GONE
            cvHelpSupport.visibility = View.GONE
            cvTeacherInfo.visibility = View.GONE
        }else{
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
        when(view!!.id){
          R.id.cvLogOut ->{
            getAppPref().clearShf()
             val intent = Intent(this,WelcomeActivity::class.java)
              startActivity(intent)
              finishAffinity()
          }R.id.btnBack ->{
                finish()
            }
        }
    }

}