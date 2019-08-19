package com.sdei.parentIn.activities

import android.content.Context
import android.os.Bundle
import com.sdei.parentIn.R
import com.sdei.parentIn.viewModel.LoginViewModel


/**
 * Created by shubham on 14/08/19.
 */

class LoginActivity : BaseActivity<LoginViewModel>() {
    override val layoutId: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val viewModel: LoginViewModel
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val context: Context
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun onCreate() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initListeners() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}
