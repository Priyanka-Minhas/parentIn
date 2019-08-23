package com.sdei.parentIn.activities

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.model.BaseModel
import com.sdei.parentIn.utils.*
import com.sdei.parentIn.viewModel.LoginViewModel
import com.wajahatkarim3.easyvalidation.core.view_ktx.nonEmpty
import com.wajahatkarim3.easyvalidation.core.view_ktx.validEmail
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_welcome.*


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
        mViewModel!!.getUser().observe(this,
                Observer<BaseModel> { mData ->
                    if (mData != null && responseHandler(mData.statusCode, mData.message)) {
                        showToast(getString(R.string.work_in_progress))
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
                if (!edtEmail.validEmail()) {
                    showAlertSnackBar(btnLogin, getString(R.string.errorValidEmail))
                } else if (!edtPassword.nonEmpty()) {
                    showAlertSnackBar(btnLogin, getString(R.string.errorValidPassword))
                } else if (connectedToInternet(btnLogin)) {
                    showProgess()
                    mViewModel!!.setLogin(edtEmail.text.toString(), edtPassword.text.toString())
                }
            }
            R.id.btnBack -> {
                finish()
            }
            R.id.btnCreateAccount -> {
                val intent = Intent(mContext, ParentsNewAccountActivity::class.java)
                startActivity(intent)
            }

        }
    }

}
