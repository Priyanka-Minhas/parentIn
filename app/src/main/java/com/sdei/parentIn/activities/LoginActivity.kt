package com.sdei.parentIn.activities

import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.viewModel.BaseViewModel
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Created by shubham on 14/08/19.
 */

class LoginActivity : BaseActivity<BaseViewModel>(), View.OnClickListener {

    override val layoutId: Int
        get() = R.layout.activity_login

    override val viewModel: BaseViewModel
        get() = ViewModelProviders.of(this).get(BaseViewModel::class.java)

    override val context: Context
        get() = this@LoginActivity

    override fun onCreate() {

    }

    override fun initListeners() {
        btnLogin.setOnClickListener(this)
        btnBack.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnLogin -> {
//                OptionDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_options,
//                        getGender(),
//                        getString(R.string.select_gender),
//                        InterfacesCall.Callback { pos ->
//
//                        }).show()
            }
            R.id.btnBack -> {
                finish()
            }
        }
    }

}
