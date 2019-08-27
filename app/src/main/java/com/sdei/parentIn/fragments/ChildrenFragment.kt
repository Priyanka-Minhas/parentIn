package com.sdei.parentIn.fragments

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.viewModel.BaseViewModel

class ChildrenFragment : BaseFragment<BaseViewModel>() {

    companion object {

        @SuppressLint("StaticFieldLeak")
        lateinit var instance: ChildrenFragment

        @SuppressLint("StaticFieldLeak")
        lateinit var mContext: Context

        fun newInstance(context: Context): ChildrenFragment {
            instance = ChildrenFragment()
            mContext = context
            return instance
        }

    }


    override val layoutId: Int
        get() = R.layout.fragment_children

    override val viewModel: BaseViewModel
        get() = ViewModelProviders.of(this).get(BaseViewModel::class.java)

    override fun onCreateStuff() {

    }

    override fun initListeners() {

    }

}
