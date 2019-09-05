package com.sdei.parentIn.activities.teacher

import android.content.Context
import android.text.TextUtils
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdei.parentIn.R
import com.sdei.parentIn.activities.BaseActivity
import com.sdei.parentIn.adapters.TeacherMsgNameAddedAdapter
import com.sdei.parentIn.dialog.TeacherMessageSelectNameDialog
import com.sdei.parentIn.model.ClassModel
import com.sdei.parentIn.viewModel.teacher.NewTeacherMessageViewModel
import kotlinx.android.synthetic.main.activity_new_message.*

class NewTeacherMessageActivity: BaseActivity<NewTeacherMessageViewModel>(), View.OnClickListener, TeacherMsgNameAddedAdapter.ClickInterface {
    override fun deleteChild(pos: Int) {
        mNameList.removeAt(pos)
        setAddNameAdapter()
    }

    override val layoutId: Int
        get() = R.layout.activity_new_message

    override val viewModel: NewTeacherMessageViewModel
        get() = ViewModelProviders.of(this).get(NewTeacherMessageViewModel::class.java)

    override val context: Context
        get() = this@NewTeacherMessageActivity

    var mClassList = arrayListOf<ClassModel.DataBean>()
    var mNameList = arrayListOf<ClassModel.DataBean>()

    lateinit var mAddAdapter: TeacherMsgNameAddedAdapter

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
                        object : TeacherMessageSelectNameDialog.IndexClick {
                            override fun clickIndex(pos: ClassModel.DataBean) {
                                if (TextUtils.isEmpty(pos._id)) {
                                    mNameList.clear()
                                    mNameList.addAll(mClassList)
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
        mAddAdapter = TeacherMsgNameAddedAdapter(mContext, mNameList, this)
        rvAddName.adapter = mAddAdapter
    }

}
