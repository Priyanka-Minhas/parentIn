package com.sdei.parentIn.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.viewModel.BaseViewModel

class VerifySchoolActivity : BaseActivity<BaseViewModel>() {
    override val layoutId: Int
        get() = R.layout.activity_verify_school
    override val viewModel: BaseViewModel
        get() = ViewModelProviders.of(this).get(BaseViewModel::class.java)
    override val context: Context
        get() = this@VerifySchoolActivity

    override fun onCreate() {

    }

    override fun initListeners() {

    }


}
