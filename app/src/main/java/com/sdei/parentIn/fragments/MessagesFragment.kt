package com.sdei.parentIn.fragments

import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.viewModel.BaseViewModel

class ParentMessageFragment : BaseFragment<BaseViewModel>() {

    override val layoutId: Int
        get() = R.layout.fragment_message

    override val viewModel: BaseViewModel
        get() = ViewModelProviders.of(this).get(BaseViewModel::class.java)

    override fun onCreateStuff() {

    }

    override fun initListeners() {

    }

}
