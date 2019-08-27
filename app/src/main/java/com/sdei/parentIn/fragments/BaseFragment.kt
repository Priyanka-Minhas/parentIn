package com.sdei.parentIn.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class BaseFragment<V : ViewModel> : Fragment() {
    var TAG: String = "BaseFragments:-"

    // since its going to be common for all the activities
    var mViewModel: V? = null
    lateinit var mContext: Context

    /**
     * @return toolbar resource id
     */
    @get:LayoutRes
    abstract val layoutId: Int

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    abstract val viewModel: V


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        this.mViewModel = if (mViewModel == null) viewModel else mViewModel
        this.mContext = this.context!!
        return inflater.inflate(layoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onCreateStuff()
        initListeners()
    }

    protected abstract fun onCreateStuff()

    protected abstract fun initListeners()

}