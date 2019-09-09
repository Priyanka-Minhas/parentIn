package com.sdei.parentIn.activities

import android.content.Context
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdei.parentIn.R
import com.sdei.parentIn.adapters.MessageAdapter
import com.sdei.parentIn.interfaces.InterConst
import com.sdei.parentIn.model.MessagesModel
import com.sdei.parentIn.utils.*
import com.sdei.parentIn.viewModel.MessageSingleViewModel
import kotlinx.android.synthetic.main.activity_message.*

class MessageActivity : BaseActivity<MessageSingleViewModel>(), View.OnClickListener {

    lateinit var to: String
    lateinit var toName: String
    var msgList = arrayListOf<MessagesModel.DataBean>()
    override val layoutId: Int
        get() = R.layout.activity_message
    override val viewModel: MessageSingleViewModel
        get() = ViewModelProviders.of(this).get(MessageSingleViewModel::class.java)
    override val context: Context
        get() = this@MessageActivity

    override fun onCreate() {
        to = intent.getStringExtra(InterConst.KEY_TO)
        toName = intent.getStringExtra(InterConst.KEY_TO_NAME)

        // get message
        if (connectedToInternet(rvMessage)) {
            showProgess()
            viewModel.getSingleMessageList(getAppPref().getString(InterConst.ID)!!, to).observe(this,
                    Observer<MessagesModel> { mData ->
                        if (mData != null && mContext.responseHandler(mData.statusCode, mData.message)) {
                            msgList = mData.data
                            setMessageAdapter()
                        }
                    })
        }

        mViewModel!!.messageCreated().observe(this,
                Observer<MessagesModel> { mData ->
                    if (mData != null && mContext.responseHandler(mData.statusCode, mData.message)) {
                        viewModel.hitMessageListApi(getAppPref().getString(InterConst.ID)!!, to)
                        setMessageAdapter()
                        edtTextSendMsg.setText("")
                    }
                })


    }

    private fun setMessageAdapter() {
        rvMessage.layoutManager = LinearLayoutManager(this)
        rvMessage.adapter = MessageAdapter(this, msgList)
        rvMessage.scrollToPosition(msgList.size - 1)
    }

    override fun initListeners() {
        btnBack.setOnClickListener(this)
        imgSend.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.btnBack -> {
                setResult(RESULT_OK)
                finish()
            }

            R.id.imgSend -> {
                if (edtTextSendMsg.text.trim().toString().isEmpty()) {
                    showAlertSnackBar(imgSend, getString(R.string.please_enter_message_first))
                    return
                }
                if (mContext.connectedToInternet(imgSend)) {
                    val toId = arrayListOf<String>()
                    val toFrom = arrayListOf<String>()
                    toId.add(to)
                    toFrom.add(toName)
                    mContext.showProgess()
                    mViewModel!!.sendMessage(toId, toFrom, edtTextSendMsg.text.trim().toString())
                }
            }
        }
    }

    override fun onBackPressed() {
        setResult(RESULT_OK)
        finish()
    }


}
