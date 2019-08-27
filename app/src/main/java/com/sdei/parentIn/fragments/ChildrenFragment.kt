package com.sdei.parentIn.fragments

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdei.parentIn.R
import com.sdei.parentIn.adapters.ChildrenAdapter
import com.sdei.parentIn.viewModel.BaseViewModel
import kotlinx.android.synthetic.main.fragment_children.*

class ChildrenFragment : BaseFragment<BaseViewModel>() {

  var childrenList = arrayListOf<String>()
   lateinit var childrenAdapter: ChildrenAdapter

    override val layoutId: Int
        get() = R.layout.fragment_children

    override val viewModel: BaseViewModel
        get() = ViewModelProviders.of(this).get(BaseViewModel::class.java)

    override fun onCreateStuff() {
      setChildrenAdapter()

    }

    private fun setChildrenAdapter() {
        rvChildren.layoutManager = LinearLayoutManager(mContext)
        childrenAdapter = ChildrenAdapter(mContext,childrenList)
        rvChildren.adapter = childrenAdapter
    }

    override fun initListeners() {

    }

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

}
