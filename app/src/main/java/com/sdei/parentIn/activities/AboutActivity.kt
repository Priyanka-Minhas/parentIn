package com.sdei.parentIn.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.viewModel.BaseViewModel

class AboutActivity : BaseActivity<BaseViewModel>() {
    override val layoutId: Int
        get() = R.layout.activity_about
    override val viewModel: BaseViewModel
        get() = ViewModelProviders.of(this).get(BaseViewModel::class.java)
    override val context: Context
        get() = this@AboutActivity

    override fun onCreate() {

    }

    override fun initListeners() {

    }


}
