package com.sdei.parentIn.fragments.parent

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdei.parentIn.R
import com.sdei.parentIn.activities.parent.ParentEditChildActivity
import com.sdei.parentIn.adapters.ChildrenAdapter
import com.sdei.parentIn.fragments.BaseFragment
import com.sdei.parentIn.interfaces.InterConst
import com.sdei.parentIn.model.ChildModel
import com.sdei.parentIn.utils.getAppPref
import com.sdei.parentIn.utils.responseHandler
import com.sdei.parentIn.utils.showProgess
import com.sdei.parentIn.viewModel.parent.ParentChildrenViewModel
import kotlinx.android.synthetic.main.fragment_parent_children.*

class ParentChildrenFragment : BaseFragment<ParentChildrenViewModel>(), ChildrenAdapter.ClickInterface, View.OnClickListener {
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnAddChild -> {
                val intent = Intent(mContext, ParentEditChildActivity::class.java)
                startActivityForResult(intent, InterConst.RESULT_CHILDREN)

            }

        }
    }

    override fun editChild(pos: Int) {
        val intent = Intent(mContext, ParentEditChildActivity::class.java)
        intent.putExtra(InterConst.CHILD_DATA, mChildrenList[pos])
        startActivityForResult(intent, InterConst.RESULT_CHILDREN)
    }

    var mChildrenList = arrayListOf<ChildModel.DataBean>()
    lateinit var childrenAdapter: ChildrenAdapter

    override val layoutId: Int
        get() = R.layout.fragment_parent_children

    override val viewModel: ParentChildrenViewModel
        get() = ViewModelProviders.of(this).get(ParentChildrenViewModel::class.java)

    override fun onCreateStuff() {
        setChildrenAdapter()
        mContext.showProgess()
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
        childrenAdapter = ChildrenAdapter(mContext, mChildrenList, this)
        rvChildren.adapter = childrenAdapter
    }

    override fun initListeners() {
        btnAddChild.setOnClickListener(this)
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var instance: ParentChildrenFragment

        fun newInstance(): ParentChildrenFragment {
            instance = ParentChildrenFragment()
            return instance
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == InterConst.RESULT_CHILDREN) {
                mViewModel!!.hitChildListApi(getAppPref().getString(InterConst.ID)!!)
            }
        }
    }

}
