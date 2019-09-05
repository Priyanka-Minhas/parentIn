package com.sdei.parentIn.activities.parent

import android.content.Context
import android.text.TextUtils
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdei.parentIn.R
import com.sdei.parentIn.activities.BaseActivity
import com.sdei.parentIn.adapters.ParentMsgNameAddedAdapter
import com.sdei.parentIn.dialog.ParentMessageSelectNameDialog
import com.sdei.parentIn.dialog.ParentMessageSelectNameDialog.IndexClick
import com.sdei.parentIn.model.ChildModel
import com.sdei.parentIn.viewModel.parent.NewParentMessageViewModel
import kotlinx.android.synthetic.main.activity_new_message.*

class NewParentMessageActivity : BaseActivity<NewParentMessageViewModel>(), View.OnClickListener, ParentMsgNameAddedAdapter.ClickInterface {

    override fun deleteChild(pos: Int) {
        mNameList.removeAt(pos)
        setAddNameAdapter()
    }

    override val layoutId: Int
        get() = R.layout.activity_new_message
    override val viewModel: NewParentMessageViewModel
        get() = ViewModelProviders.of(this).get(NewParentMessageViewModel::class.java)
    override val context: Context
        get() = this@NewParentMessageActivity

    var mChildrenList = arrayListOf<ChildModel.DataBean>()
    var mNameList = arrayListOf<ChildModel.DataBean>()

    lateinit var mAddAdapter: ParentMsgNameAddedAdapter

    override fun onCreate() {
        setAddNameAdapter()

        mViewModel!!.getChildList().observe(this,
                Observer<ArrayList<ChildModel.DataBean>> { mData ->
                    if (mData != null) {
                        mChildrenList = mData
                    }
                })
    }

    override fun initListeners() {
        btnBack.setOnClickListener(this)
        txtSubmit.setOnClickListener(this)
        imgAdd.setOnClickListener(this)
        layoutAttach.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view!!.id) {

            R.id.btnBack -> {
                finish()
            }

            R.id.imgAdd -> {
                ParentMessageSelectNameDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_message_select_name,
                        mChildrenList,
                        object : IndexClick {
                            override fun clickIndex(pos: ChildModel.DataBean) {
                                if (TextUtils.isEmpty(pos._id)) {
                                    mNameList.clear()
                                    mNameList.addAll(mChildrenList)
                                } else {
                                    if (!mNameList.contains(pos)) {
                                        mNameList.add(pos)
                                    }
                                }
                                setAddNameAdapter()
                            }
                        }).show()
            }

            R.id.layoutAttach -> {

            }
        }
    }

    private fun setAddNameAdapter() {
        rvAddName.layoutManager = LinearLayoutManager(mContext)
        mAddAdapter = ParentMsgNameAddedAdapter(mContext, mNameList, this)
        rvAddName.adapter = mAddAdapter
    }

}
