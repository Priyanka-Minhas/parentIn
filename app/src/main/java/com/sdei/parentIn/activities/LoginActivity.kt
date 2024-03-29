package com.sdei.parentIn.activities

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.activities.parent.ParentLandingActivity
import com.sdei.parentIn.activities.parent.ParentsRegisterActivity
import com.sdei.parentIn.activities.teacher.TeacherLandingActivity
import com.sdei.parentIn.activities.teacher.TeacherRegisterActivity
import com.sdei.parentIn.interfaces.InterConst
import com.sdei.parentIn.model.UserModel
import com.sdei.parentIn.utils.*
import com.sdei.parentIn.viewModel.LoginViewModel
import com.wajahatkarim3.easyvalidation.core.view_ktx.nonEmpty
import com.wajahatkarim3.easyvalidation.core.view_ktx.validEmail
import kotlinx.android.synthetic.main.activity_login.*


/**
 * Created by shubham on 14/08/19.
 */

class LoginActivity : BaseActivity<LoginViewModel>(), View.OnClickListener {

    override val layoutId: Int
        get() = R.layout.activity_login

    override val viewModel: LoginViewModel
        get() = ViewModelProviders.of(this).get(LoginViewModel::class.java)

    override val context: Context
        get() = this@LoginActivity

    override fun onCreate() {


        if (getAppPref().getInt(InterConst.ROLE_ID) == InterConst.ROLE_TEACHER) {
            txtHeader.text = mContext.resources.getString(R.string.BIENVENIDO) + " " + mContext.resources.getString(R.string.Maestro)
        }


        mViewModel!!.getUser().observe(this,
                Observer<UserModel> { mData ->
                    if (mData != null && responseHandler(mData.statusCode, mData.message)) {
                        saveUserData(mData.data)
                        val intent = if (getAppPref().getInt(InterConst.ROLE_ID) == InterConst.ROLE_PARENT) {
                            Intent(mContext, ParentLandingActivity::class.java)
                        } else {
                            Intent(mContext, TeacherLandingActivity::class.java)
                        }
                        startActivity(intent)
                        finishAffinity()
                    }
                })
    }

    override fun initListeners() {
        btnLogin.setOnClickListener(this)
        btnBack.setOnClickListener(this)
        btnCreateAccount.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnLogin -> {
                if (!edtEmail.nonEmpty()) {
                    showAlertSnackBar(btnLogin, getString(R.string.errorEmail))
                } else if (!edtEmail.validEmail()) {
                    showAlertSnackBar(btnLogin, getString(R.string.errorValidEmail))
                } else if (!edtPassword.nonEmpty()) {
                    showAlertSnackBar(btnLogin, getString(R.string.errorValidPassword))
                } else if (connectedToInternet(btnLogin)) {
                    showProgess()
                    mViewModel!!.setLogin(edtEmail.text.toString(), edtPassword.text.toString(), getAppPref().getInt(InterConst.ROLE_ID))
                }
            }

            R.id.btnBack -> {
                finish()
            }

            R.id.btnCreateAccount -> {
                edtEmail.setText("")
                edtPassword.setText("")

                val intent = if (getAppPref().getInt(InterConst.ROLE_ID) == InterConst.ROLE_PARENT) {
                    Intent(mContext, ParentsRegisterActivity::class.java)
                } else {
                    Intent(mContext, TeacherRegisterActivity::class.java)
                }
                startActivity(intent)
            }

        }
    }

}
