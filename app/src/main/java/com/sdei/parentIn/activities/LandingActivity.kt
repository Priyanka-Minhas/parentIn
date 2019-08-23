package com.sdei.parentIn.activities

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.viewModel.BaseViewModel

class LandingActivity : BaseActivity<BaseViewModel>() {

    override val layoutId: Int
        get() = R.layout.activity_landing

    override val viewModel: BaseViewModel
        get() = ViewModelProviders.of(this).get(BaseViewModel::class.java)

    override val context: Context
        get() = this@LandingActivity

    override fun onCreate() {

    }

    override fun initListeners() {

    }


}
