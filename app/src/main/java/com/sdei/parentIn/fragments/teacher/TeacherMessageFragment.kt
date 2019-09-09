package com.sdei.parentIn.fragments.teacher

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdei.parentIn.R
import com.sdei.parentIn.activities.MessageActivity
import com.sdei.parentIn.activities.teacher.NewTeacherMessageActivity
import com.sdei.parentIn.adapters.MessagesDialogAdapter
import com.sdei.parentIn.dialog.MessageReplyDialog
import com.sdei.parentIn.fragments.BaseFragment
import com.sdei.parentIn.interfaces.InterConst
import com.sdei.parentIn.model.MessagesModel
import com.sdei.parentIn.utils.*
import com.sdei.parentIn.viewModel.MessageDialogVM
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
            override fun openActivity(pos: Int) {
                val intent = Intent(context, MessageActivity::class.java)
                if (getAppPref().getString(InterConst.ID) != mDialoglist[pos].from) {
                    intent.putExtra(InterConst.KEY_TO,mDialoglist[pos].from)
                    intent.putExtra(InterConst.KEY_TO_NAME,mDialoglist[pos].fromName)
                } else {
                    intent.putExtra(InterConst.KEY_TO,mDialoglist[pos].to)
                    intent.putExtra(InterConst.KEY_TO_NAME,mDialoglist[pos].toName)
                }
                startActivityForResult(intent, 1001)
            }


            override fun getIndex(pos: Int, to: String, toName: String) {
                messageReplyDialog = MessageReplyDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_reply_message,mDialoglist[pos], object : MessageReplyDialog.IndexClick {
                    override fun clickIndex(message: String) {
                        if (message.isEmpty()) {
                            showAlertSnackBar(rvParentMessages, getString(R.string.please_enter_message_first))
                            return
                        }
                        if (mContext.connectedToInternet(rvParentMessages)) {
                            val toId = arrayListOf<String>()
                            val toFrom = arrayListOf<String>()
                            toId.add(to)
                            toFrom.add(toName)
                            mContext.showProgess()
                            mViewModel!!.sendMessage(toId, toFrom, message)
                        }
                    }
                })
                messageReplyDialog!!.show()
            }
        })
    }

    override fun initListeners() {
        btnNewMessage.setOnClickListener {
            val intent = Intent(mContext, NewTeacherMessageActivity::class.java)
            startActivityForResult(intent, 1001)
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1001 && resultCode == Activity.RESULT_OK) {
            mViewModel!!.getMessageList()
        }
    }


}