package com.sdei.parentIn.activities

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.viewModel.BaseViewModel


/**
 * Created by shubham on 14/08/19.
 */

class LoginActivity : BaseActivity<BaseViewModel>() {

    override val layoutId: Int
        get() = R.layout.activity_login

    override val viewModel: BaseViewModel
        get() = ViewModelProviders.of(this).get(BaseViewModel::class.java)

    override val context: Context
        get() = this@LoginActivity

    override fun onCreate() {
    }

    override fun initListeners() {

    }
}
