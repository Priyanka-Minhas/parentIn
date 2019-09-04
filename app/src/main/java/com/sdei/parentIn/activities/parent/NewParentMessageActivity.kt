package com.sdei.parentIn.activities.parent

import android.content.Context
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.activities.BaseActivity
import com.sdei.parentIn.dialog.ParentMessageSelectNameDialog
import com.sdei.parentIn.interfaces.InterfacesCall
import com.sdei.parentIn.model.ChildModel
import com.sdei.parentIn.viewModel.parent.NewParentMessageViewModel
import kotlinx.android.synthetic.main.activity_new_message.*

class NewParentMessageActivity : BaseActivity<NewParentMessageViewModel>(), View.OnClickListener {

    override val layoutId: Int
        get() = R.layout.activity_new_message
    override val viewModel: NewParentMessageViewModel
        get() = ViewModelProviders.of(this).get(NewParentMessageViewModel::class.java)
    override val context: Context
        get() = this@NewParentMessageActivity

    var mChildrenList = arrayListOf<ChildModel.DataBean>()

    override fun onCreate() {
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
                        InterfacesCall.Callback { pos ->
                        }).show()
            }
            R.id.layoutAttach -> {

            }
        }
    }

}
