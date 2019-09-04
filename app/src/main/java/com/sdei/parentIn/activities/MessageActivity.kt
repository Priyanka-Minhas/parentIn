package com.sdei.parentIn.activities

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdei.parentIn.R
import com.sdei.parentIn.adapters.MessageAdapter
import com.sdei.parentIn.viewModel.BaseViewModel
import kotlinx.android.synthetic.main.activity_message.*

class MessageActivity : BaseActivity<BaseViewModel>() {
   val msgList = arrayListOf<String>("Masseage1","Message2","Message3")
   val msgAdapter : MessageAdapter? = null
    override val layoutId: Int
        get() = R.layout.activity_message
    override val viewModel: BaseViewModel
        get() = ViewModelProviders.of(this).get(BaseViewModel::class.java)
    override val context: Context
        get() = this@MessageActivity

    override fun onCreate() {
        setMessageAdapter()

    }

    private fun setMessageAdapter() {
        rvMessage.layoutManager = LinearLayoutManager(this)
        rvMessage.adapter = MessageAdapter(this,msgList)
    }

    override fun initListeners() {

    }

}
