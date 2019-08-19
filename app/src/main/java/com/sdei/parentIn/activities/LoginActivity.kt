package com.sdei.parentIn.activities

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.viewModel.LoginViewModel


/**
 * Created by shubham on 14/08/19.
 */

class LoginActivity : BaseActivity<LoginViewModel>() {
    override val layoutId: Int
        get() = R.layout.activity_login
    override val viewModel: LoginViewModel
        get() = ViewModelProviders.of(this).get(LoginViewModel::class.java)
    override val context: Context
        get() = this@LoginActivity

    override fun onCreate() {

    }

    override fun initListeners() {

    }

}
