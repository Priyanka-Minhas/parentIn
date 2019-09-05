package com.sdei.parentIn.activities.supervisor

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.activities.BaseActivity
import com.sdei.parentIn.utils.showAlertSnackBar
import com.sdei.parentIn.viewModel.BaseViewModel
import com.wajahatkarim3.easyvalidation.core.view_ktx.validEmail
import kotlinx.android.synthetic.main.activity_parents_new_account.*
import kotlinx.android.synthetic.main.activity_superviser.*

class SupervisorLoginActivity : BaseActivity<BaseViewModel>(), View.OnClickListener {

    override val layoutId: Int
        get() = R.layout.activity_superviser
    override val viewModel: BaseViewModel
        get() = ViewModelProviders.of(this).get(BaseViewModel::class.java)
    override val context: Context
        get() = this@SupervisorLoginActivity
    override fun onCreate() {

    }

    override fun initListeners() {

        txtForgetPass.setOnClickListener(this)
        btnSupervisorLogin.setOnClickListener(this)
        txtRegistration.setOnClickListener(this)
    }


    override fun onClick(view: View?) {
       when(view!!.id){
         R.id.txtForgetPass ->{}
         R.id.txtRegistration ->{
             val intent =Intent(this,SupervisorRegistrationActivity::class.java)
             startActivity(intent)
         }
         R.id.btnSupervisorLogin ->{
             if(edtSupervisorEmail.text.trim().isEmpty()){
                 showAlertSnackBar(btnSupervisorLogin, getString(R.string.errorEmail))
             }else if(!edtSupervisorEmail.validEmail()){
                 showAlertSnackBar(btnSupervisorLogin, getString(R.string.errorValidEmail))
             }else if(edtSupervisorPassword.text.trim().isEmpty()){
                 showAlertSnackBar(btnSupervisorLogin, getString(R.string.errorValidPassword))
             }else{

             }
         }
       }
    }


}
