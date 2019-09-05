package com.sdei.parentIn.activities.supervisor

import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.activities.BaseActivity
import com.sdei.parentIn.dialog.OptionListDialog
import com.sdei.parentIn.interfaces.InterfacesCall
import com.sdei.parentIn.utils.connectedToInternet
import com.sdei.parentIn.utils.getGender
import com.sdei.parentIn.utils.getOrganization
import com.sdei.parentIn.utils.showAlertSnackBar
import com.sdei.parentIn.viewModel.BaseViewModel
import com.wajahatkarim3.easyvalidation.core.view_ktx.validEmail
import kotlinx.android.synthetic.main.activity_parent_edit_child.*
import kotlinx.android.synthetic.main.activity_parents_new_account.*
import kotlinx.android.synthetic.main.activity_supervisor_registration.*
import kotlinx.android.synthetic.main.activity_supervisor_registration.btnBack
import kotlinx.android.synthetic.main.dialog_reply_message.*

class SupervisorRegistrationActivity : BaseActivity<BaseViewModel>(), View.OnClickListener {


    override val layoutId: Int
        get() = R.layout.activity_supervisor_registration
    override val viewModel: BaseViewModel
        get() = ViewModelProviders.of(this).get(BaseViewModel::class.java)
    override val context: Context
        get() = this@SupervisorRegistrationActivity

    override fun onCreate() {

    }

    override fun initListeners() {
        btnBack.setOnClickListener(this)
        edtSupGender.setOnClickListener(this)
        edtSupOrganization.setOnClickListener(this)
        btnSupCreateAccount.setOnClickListener(this)
        edtSupGender.setOnClickListener(this)

    }
    override fun onClick(view: View?) {
       when(view!!.id){
          R.id.btnBack ->{
              finish()
          }R.id.edtSupGender ->{
           OptionListDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_options,
                   getGender(),
                   getString(R.string.select_gender),
                   InterfacesCall.Callback { pos ->
                       edtSupGender.setText(getGender()[pos].name.toString())
                   }).show()
         }R.id.btnSupCreateAccount -> {
           if (edtSupFirstName.text.trim().isEmpty()) {
               showAlertSnackBar(btnSupCreateAccount, getString(R.string.errorFirstName))
           } else if (edtSupLastName.text.trim().isEmpty()) {
               showAlertSnackBar(btnSupCreateAccount, getString(R.string.errorLastName))
           } else if (edtSupGender.text.trim().isEmpty()){
               showAlertSnackBar(btnSupCreateAccount, getString(R.string.errorGender))
           }else if(edtSupIdCard.text.trim().isEmpty()){
               showAlertSnackBar(btnSupCreateAccount, getString(R.string.errorIdentification))
           }else if(edtSupOrganization.text.trim().isEmpty()){
               showAlertSnackBar(btnSupCreateAccount, getString(R.string.errorOrganization))
           }else if(edtSupTitle.text.trim().isEmpty()){
               showAlertSnackBar(btnSupCreateAccount, getString(R.string.errorTitle))
           }else if(edtSupEmail.text.trim().isEmpty()){
               showAlertSnackBar(btnSupCreateAccount, getString(R.string.errorEmail))
           }else if(!edtSupEmail.validEmail()){
               showAlertSnackBar(btnSupCreateAccount, getString(R.string.errorValidEmail))
           }else if(edtSupConfEmail.text.toString() != edtSupEmail.text.toString()){
               showAlertSnackBar(btnSupCreateAccount, getString(R.string.errorConfEmail))
           }else if(edtSupPass.text.trim().isEmpty()){
               showAlertSnackBar(btnSupCreateAccount, getString(R.string.errorValidPassword))
           }else if(edtSupConfPass.text.toString()!=edtSupPass.text.toString()){
               showAlertSnackBar(btnSupCreateAccount, getString(R.string.errorConfirmPassword))
           }else{
               if(connectedToInternet(btnSupCreateAccount)){

               }
           }

         }
       }
    }

}
