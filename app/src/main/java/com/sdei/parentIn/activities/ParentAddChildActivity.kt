package com.sdei.parentIn.activities

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.viewModel.BaseViewModel

class ParentAddChildActivity : BaseActivity<BaseViewModel>() {

    override val layoutId: Int
        get() = R.layout.activity_parent_add_child

    override val viewModel: BaseViewModel
        get() = ViewModelProviders.of(this).get(BaseViewModel::class.java)

    override val context: Context
        get() = this@ParentAddChildActivity

    override fun onCreate() {

    }

    override fun initListeners() {

    }
}
