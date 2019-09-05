package com.sdei.parentIn.fragments.teacher

import android.annotation.SuppressLint
import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdei.parentIn.R
import com.sdei.parentIn.activities.teacher.NewTeacherMessageActivity
import com.sdei.parentIn.adapters.MessagesDialogAdapter
import com.sdei.parentIn.dialog.MessageReplyDialog
import com.sdei.parentIn.fragments.BaseFragment
import com.sdei.parentIn.model.MessagesModel
import com.sdei.parentIn.utils.responseHandler
import com.sdei.parentIn.viewModel.MessageDialogVM
import kotlinx.android.synthetic.main.fragment_teacher_messages.*

class TeacherMessageFragment : BaseFragment<MessageDialogVM>() {

    var mDialoglist = arrayListOf<MessagesModel.DataBean>()

    var messageReplyDialog: MessageReplyDialog? = null
    lateinit var mAdapter: MessagesDialogAdapter

    override val layoutId: Int
        get() = R.layout.fragment_teacher_messages

    override val viewModel: MessageDialogVM
        get() = ViewModelProviders.of(this).get(MessageDialogVM::class.java)

    override fun onCreateStuff() {

        setParentMessageAdapter()

        btnNewMessage.setOnClickListener {
            val intent = Intent(mContext, NewTeacherMessageActivity::class.java)
            startActivity(intent)
        }
        mViewModel!!.getMessageList().observe(this,
                Observer<MessagesModel> { mData ->
                    if (mData != null && mContext.responseHandler(mData.statusCode, mData.message)) {
                        mDialoglist = mData.data
                        setParentMessageAdapter()
                    }
                })

    }

    private fun setParentMessageAdapter() {
        rvParentMessages.layoutManager = LinearLayoutManager(mContext)
        mAdapter = MessagesDialogAdapter(mContext, mDialoglist, object : MessagesDialogAdapter.Callback {
            override fun getIndex(pos: Int) {
                messageReplyDialog = MessageReplyDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_reply_message)
                messageReplyDialog!!.show()
            }
        })
        rvParentMessages.adapter = mAdapter
    }

    override fun initListeners() {

    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var instance: TeacherMessageFragment

        fun newInstance(): TeacherMessageFragment {
            instance = TeacherMessageFragment()
            return instance
        }
    }

}