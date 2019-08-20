package com.sdei.parentIn.activities

import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdei.parentIn.R
import com.sdei.parentIn.adapters.AddChildAdapter
import com.sdei.parentIn.model.ChildModel
import com.sdei.parentIn.viewModel.BaseViewModel
import kotlinx.android.synthetic.main.activity_parent_add_child.*

class ParentAddChildActivity : BaseActivity<BaseViewModel>(), View.OnClickListener, AddChildAdapter.ClickInterface {

    override fun deleteClick(pos: Int) {
        mData.removeAt(pos)
        mChildAdapter.notifyDataSetChanged()
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnAddChild -> {
                mData.add(ChildModel())
                mChildAdapter.notifyDataSetChanged()
            }
            R.id.btnBack -> {
                finish()
            }
        }
    }

    override val layoutId: Int
        get() = R.layout.activity_parent_add_child

    override val viewModel: BaseViewModel
        get() = ViewModelProviders.of(this).get(BaseViewModel::class.java)

    override val context: Context
        get() = this@ParentAddChildActivity


    var mData = arrayListOf<ChildModel>()

    lateinit var mChildAdapter: AddChildAdapter

    override fun onCreate() {

        mData.add(ChildModel())
        setChildAdapter()
    }

    override fun initListeners() {
        btnAddChild.setOnClickListener(this)
    }

    private fun setChildAdapter() {
        rvAddChild.layoutManager = LinearLayoutManager(mContext)
        mChildAdapter = AddChildAdapter(mContext, mData, this)
        rvAddChild.adapter = mChildAdapter
    }

}
