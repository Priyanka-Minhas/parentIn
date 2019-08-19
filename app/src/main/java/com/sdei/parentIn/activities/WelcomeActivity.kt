package com.sdei.parentIn.activities

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.viewModel.BaseViewModel
import kotlinx.android.synthetic.main.activity_welcome.*

/**
 * Created by priyanka on 14/08/19.
 */

class WelcomeActivity : BaseActivity<BaseViewModel>(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.cdParent -> {
                var intent = Intent(mContext, LoginActivity::class.java)
                startActivity(intent)
            }

        }

    }

    override val layoutId: Int
        get() = R.layout.activity_welcome

    override val viewModel: BaseViewModel
        get() = ViewModelProviders.of(this).get(BaseViewModel::class.java)

    override val context: Context
        get() = this@WelcomeActivity

    override fun onCreate() {

    }

    override fun initListeners() {
        cdParent.setOnClickListener(this)
    }

}
