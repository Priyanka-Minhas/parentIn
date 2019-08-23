package com.sdei.parentIn.activities

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.viewModel.BaseViewModel
import kotlinx.android.synthetic.main.activity_landing.*

class LandingActivity : BaseActivity<BaseViewModel>(), View.OnClickListener {
    override fun onClick(v: View?) {
        val intent = Intent(mContext, WelcomeActivity::class.java)
        startActivity(intent)
        finishAffinity()
    }

    override val layoutId: Int
        get() = R.layout.activity_landing

    override val viewModel: BaseViewModel
        get() = ViewModelProviders.of(this).get(BaseViewModel::class.java)

    override val context: Context
        get() = this@LandingActivity

    override fun onCreate() {

    }

    override fun initListeners() {
        txtLogout.setOnClickListener(this)
    }


}
