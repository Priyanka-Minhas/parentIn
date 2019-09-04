package com.sdei.parentIn.activities.teacher

import android.content.Context
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.activities.BaseActivity
import com.sdei.parentIn.dialog.TeacherMessageSelectNameDialog
import com.sdei.parentIn.interfaces.InterfacesCall
import com.sdei.parentIn.model.ClassModel
import com.sdei.parentIn.viewModel.teacher.NewTeacherMessageViewModel
import kotlinx.android.synthetic.main.activity_new_message.*

class NewTeacherMessageActivity: BaseActivity<NewTeacherMessageViewModel>(), View.OnClickListener {

    override val layoutId: Int
        get() = R.layout.activity_new_message
    override val viewModel: NewTeacherMessageViewModel
        get() = ViewModelProviders.of(this).get(NewTeacherMessageViewModel::class.java)
    override val context: Context
        get() = this@NewTeacherMessageActivity

    var mClassList = arrayListOf<ClassModel.DataBean>()

    override fun onCreate() {
        mViewModel!!.getClassList().observe(this,
                Observer<ArrayList<ClassModel.DataBean>> { mData ->
                    if (mData != null) {
                        mClassList = mData
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
                TeacherMessageSelectNameDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_message_select_name,
                        mClassList,
                        InterfacesCall.Callback { pos ->

                        }).show()
            }
            R.id.layoutAttach -> {

            }
        }
    }

}
