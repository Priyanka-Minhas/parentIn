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
import com.sdei.parentIn.utils.connectedToInternet
import com.sdei.parentIn.utils.responseHandler
import com.sdei.parentIn.utils.showProgess
import com.sdei.parentIn.viewModel.BaseViewModel
import com.sdei.parentIn.viewModel.MessageSingleViewModel
import kotlinx.android.synthetic.main.activity_message.*

class MessageActivity : BaseActivity<MessageSingleViewModel>(), View.OnClickListener {

    lateinit var to :String
   lateinit var from :String
   var msgList = arrayListOf<MessagesModel.DataBean>()
   //val msgAdapter : MessageAdapter? = null
    override val layoutId: Int
        get() = R.layout.activity_message
    override val viewModel: MessageSingleViewModel
        get() = ViewModelProviders.of(this).get(MessageSingleViewModel::class.java)
    override val context: Context
        get() = this@MessageActivity

    override fun onCreate() {
        to = intent.getStringExtra(InterConst.KEY_TO)
        from = intent.getStringExtra(InterConst.KEY_FROM)

        // get message
        if(connectedToInternet(rvMessage)){
            showProgess()
            viewModel!!.getSingleMessageList(from,to).observe(this,
                    Observer<MessagesModel> {mData ->
                        if (mData != null && mContext.responseHandler(mData.statusCode, mData.message)){
                          msgList = mData.data
                            setMessageAdapter()
                        }
                    })
        }
    }

    private fun setMessageAdapter() {
        rvMessage.layoutManager = LinearLayoutManager(this)
        rvMessage.adapter = MessageAdapter(this,msgList)
    }

    override fun initListeners() {
            btnBack.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view!!.id){
            R.id.btnBack ->{
                finish()
            }
        }
    }


}
