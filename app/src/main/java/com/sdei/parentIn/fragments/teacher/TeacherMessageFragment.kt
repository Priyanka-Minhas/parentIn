package com.sdei.parentIn.fragments.teacher

import android.annotation.SuppressLint
import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdei.parentIn.R
import com.sdei.parentIn.activities.teacher.NewTeacherMessageActivity
import com.sdei.parentIn.adapters.ParentMessagesAdapter
import com.sdei.parentIn.dialog.MessageReplyDialog
import com.sdei.parentIn.fragments.BaseFragment
import com.sdei.parentIn.viewModel.BaseViewModel
import kotlinx.android.synthetic.main.fragment_teacher_messages.*

class TeacherMessageFragment : BaseFragment<BaseViewModel>(){

    var list = arrayListOf<String>("Khem","Subham","C","D")

    lateinit var parentMsgAdapter : ParentMessagesAdapter

    var messageReplyDialog : MessageReplyDialog? = null

    override val layoutId: Int
        get() = R.layout.fragment_teacher_messages

    override val viewModel: BaseViewModel
        get() = ViewModelProviders.of(this).get(BaseViewModel::class.java)

    override fun onCreateStuff() {
        btnNewMessage.setOnClickListener {
            val intent = Intent(mContext, NewTeacherMessageActivity::class.java)
            startActivity(intent)
        }
        setParentMessageAdapter()
    }

    private fun setParentMessageAdapter() {
        rvParentMessages.layoutManager = LinearLayoutManager(mContext)
        rvParentMessages.adapter = ParentMessagesAdapter(mContext,list,object: ParentMessagesAdapter.Callback {
            override fun getIndex(pos: Int) {
                messageReplyDialog = MessageReplyDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_reply_message)
                messageReplyDialog!!.show()
            }
        })
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