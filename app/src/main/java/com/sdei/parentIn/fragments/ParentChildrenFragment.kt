package com.sdei.parentIn.fragments

import android.annotation.SuppressLint
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdei.parentIn.R
import com.sdei.parentIn.adapters.ChildrenAdapter
import com.sdei.parentIn.interfaces.InterConst
import com.sdei.parentIn.model.ChildModel
import com.sdei.parentIn.utils.getAppPref
import com.sdei.parentIn.utils.responseHandler
import com.sdei.parentIn.viewModel.parent.ParentLandingViewModel
import kotlinx.android.synthetic.main.fragment_children.*

class ParentChildrenFragment : BaseFragment<ParentLandingViewModel>() {

    var mChildrenList = arrayListOf<ChildModel.DataBean>()
    lateinit var childrenAdapter: ChildrenAdapter

    override val layoutId: Int
        get() = R.layout.fragment_children

    override val viewModel: ParentLandingViewModel
        get() = ViewModelProviders.of(this).get(ParentLandingViewModel::class.java)

    override fun onCreateStuff() {
        setChildrenAdapter()
        mViewModel!!.hitChildListApi(getAppPref().getString(InterConst.ID)!!)

        mViewModel!!.getChild().observe(this,
                Observer<ChildModel> { mData ->
                    if (mData != null && mContext.responseHandler(mData.statusCode, mData.message)) {
                        mChildrenList = mData.data
                        setChildrenAdapter()
                    }
                })

    }

    private fun setChildrenAdapter() {
        rvChildren.layoutManager = LinearLayoutManager(mContext)
        childrenAdapter = ChildrenAdapter(mContext, mChildrenList)
        rvChildren.adapter = childrenAdapter
    }

    override fun initListeners() {

    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var instance: ParentChildrenFragment

        fun newInstance(): ParentChildrenFragment {
            instance = ParentChildrenFragment()
            return instance
        }
    }

}
