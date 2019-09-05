package com.sdei.parentIn.fragments.parent

import android.annotation.SuppressLint
import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdei.parentIn.R
import com.sdei.parentIn.activities.SurveySelectSchoolActivity
import com.sdei.parentIn.activities.parent.NewParentMessageActivity
import com.sdei.parentIn.adapters.MessagesDialogAdapter
import com.sdei.parentIn.adapters.MessagesDialogAdapter.Callback
import com.sdei.parentIn.dialog.MessageReplyDialog
import com.sdei.parentIn.fragments.BaseFragment
import com.sdei.parentIn.model.MessagesModel
import com.sdei.parentIn.utils.connectedToInternet
import com.sdei.parentIn.viewModel.BaseViewModel
import kotlinx.android.synthetic.main.fragment_parent_messages.*

class ParentMessagesFragment : BaseFragment<BaseViewModel>(){

    var mDialoglist = arrayListOf<MessagesModel.DataBean>()

    var messageReplyDialog : MessageReplyDialog? = null
    override val layoutId: Int
        get() = R.layout.fragment_parent_messages
    override val viewModel: BaseViewModel
        get() = ViewModelProviders.of(this).get(BaseViewModel::class.java)

    override fun onCreateStuff() {

        btnForSurvay.setOnClickListener {
            if (mContext.connectedToInternet(btnForSurvay)) {
                val intent = Intent(mContext, SurveySelectSchoolActivity::class.java)
                startActivity(intent)
            }
        }

        btnNewMessage.setOnClickListener {
            val intent = Intent(mContext, NewParentMessageActivity::class.java)
            startActivity(intent)
        }

        setParentMessageAdapter()
    }

    private fun setParentMessageAdapter() {
        rvParentMessages.layoutManager = LinearLayoutManager(mContext)
        rvParentMessages.adapter = MessagesDialogAdapter(mContext,mDialoglist,object:Callback{
            override fun getIndex(pos: Int) {
             messageReplyDialog = MessageReplyDialog(mContext,R.style.pullBottomfromTop,R.layout.dialog_reply_message)
             messageReplyDialog!!.show()
            }
        })
    }

    override fun initListeners() {

    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var instance: ParentMessagesFragment

        fun newInstance(): ParentMessagesFragment {
            instance = ParentMessagesFragment()
            return instance
        }
    }

}