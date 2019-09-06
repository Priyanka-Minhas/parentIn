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
import com.sdei.parentIn.utils.connectedToInternet
import com.sdei.parentIn.utils.responseHandler
import com.sdei.parentIn.utils.showAlertSnackBar
import com.sdei.parentIn.utils.showProgess
import com.sdei.parentIn.viewModel.MessageDialogVM
import kotlinx.android.synthetic.main.activity_new_message.*
import kotlinx.android.synthetic.main.fragment_teacher_messages.*

class TeacherMessageFragment : BaseFragment<MessageDialogVM>() {

    var mDialoglist = arrayListOf<MessagesModel.DataBean>()

    var messageReplyDialog: MessageReplyDialog? = null
    override val layoutId: Int
        get() = R.layout.fragment_teacher_messages

    override val viewModel: MessageDialogVM
        get() = ViewModelProviders.of(this).get(MessageDialogVM::class.java)

    override fun onCreateStuff() {

        setParentMessageAdapter()

        mViewModel!!.messageListResponse().observe(this,
                Observer<MessagesModel> { mData ->
                    if (mData != null && mContext.responseHandler(mData.statusCode, mData.message)) {
                        mDialoglist = mData.data
                        setParentMessageAdapter()
                    }
                })

        mViewModel!!.messageCreated().observe(this,
                Observer<MessagesModel> { mData ->
                    if (mData != null && mContext.responseHandler(mData.statusCode, mData.message)) {
                        messageReplyDialog!!.dismiss()
                        mViewModel!!.getMessageList()
                    }
                })

    }

    private fun setParentMessageAdapter() {
        rvParentMessages.layoutManager = LinearLayoutManager(mContext)
        rvParentMessages.adapter = MessagesDialogAdapter(mContext, mDialoglist, object : MessagesDialogAdapter.Callback {
            override fun getIndex(pos: Int, from: String, fromName: String) {
                messageReplyDialog = MessageReplyDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_reply_message, mDialoglist[pos], object : MessageReplyDialog.IndexClick {
                    override fun clickIndex(message: String) {
                        if (message.isEmpty()) {
                            showAlertSnackBar(imgAdd, getString(R.string.please_enter_message_first))
                            return
                        }
                        if (mContext.connectedToInternet(btnNewMessage)) {
                            val toId = arrayListOf<String>()
                            val toFrom = arrayListOf<String>()
                            toId.add(from)
                            toFrom.add(fromName)
                            mContext.showProgess()
                            mViewModel!!.sendMessage(toId, toFrom, message)
                        }
                    }
                })
                messageReplyDialog!!.show()
            }
        })
    }

    override fun onResume() {
        super.onResume()
        mViewModel!!.getMessageList()
    }


    override fun initListeners() {
        btnNewMessage.setOnClickListener {
            val intent = Intent(mContext, NewTeacherMessageActivity::class.java)
            startActivity(intent)
        }
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