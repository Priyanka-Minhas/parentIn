package com.sdei.parentIn.activities

import android.content.Context
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdei.parentIn.R
import com.sdei.parentIn.adapters.AddChildAdapter
import com.sdei.parentIn.model.UserModel
import com.sdei.parentIn.utils.DATA
import com.sdei.parentIn.utils.connectedToInternet
import com.sdei.parentIn.utils.responseHandler
import com.sdei.parentIn.utils.showToast
import com.sdei.parentIn.viewModel.ParentNewAccountViewModel
import kotlinx.android.synthetic.main.activity_parent_add_child.*


class ParentAddChildActivity : BaseActivity<ParentNewAccountViewModel>(), View.OnClickListener, AddChildAdapter.ClickInterface {

    override fun deleteChild(pos: Int) {
        mData.removeAt(pos)
        mChildAdapter.notifyDataSetChanged()
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnAddChild -> {
                mData.add(UserModel.DataBean.ChildsBean())
                mChildAdapter.notifyDataSetChanged()
            }

            R.id.txtCreateAccount -> {
                val i = intent
                val model = i.getParcelableExtra(DATA) as UserModel.DataBean
                if (connectedToInternet(btnAddChild)) {
                    Log.e("=======", "ierieu" + model.firstName)
                    // mViewModel!!.setProfile(model)
                }
            }

            R.id.btnBack -> {
                finish()
            }
        }
    }

    override val layoutId: Int
        get() = R.layout.activity_parent_add_child

    override val viewModel: ParentNewAccountViewModel
        get() = ViewModelProviders.of(this).get(ParentNewAccountViewModel::class.java)

    override val context: Context
        get() = this@ParentAddChildActivity

    var mData = arrayListOf<UserModel.DataBean.ChildsBean>()

    lateinit var mChildAdapter: AddChildAdapter

    override fun onCreate() {
        mData.add(UserModel.DataBean.ChildsBean())
        setChildAdapter()

        mViewModel!!.getProfile().observe(this,
                Observer<UserModel> { mData ->
                    if (mData != null && responseHandler(mData.statusCode, mData.message)) {
                        showToast(getString(R.string.work_in_progress))
                    }
                })

    }

    override fun initListeners() {
        btnAddChild.setOnClickListener(this)
        txtCreateAccount.setOnClickListener(this)
        btnBack.setOnClickListener(this)
    }

    private fun setChildAdapter() {
        rvAddChild.layoutManager = LinearLayoutManager(mContext)
        mChildAdapter = AddChildAdapter(mContext, mData, this)
        rvAddChild.adapter = mChildAdapter
    }

}
