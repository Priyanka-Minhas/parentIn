package com.sdei.parentIn.fragments.parent

import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdei.parentIn.R
import com.sdei.parentIn.activities.VerifySchoolActivity
import com.sdei.parentIn.adapters.MessagesAdapter
import com.sdei.parentIn.fragments.BaseFragment
import com.sdei.parentIn.viewModel.BaseViewModel
import kotlinx.android.synthetic.main.fragment_message.*

class ParentMessageFragment : BaseFragment<BaseViewModel>(), View.OnClickListener {


    var msgList = arrayListOf<String>()
    lateinit var messageAdapter: MessagesAdapter
    override val layoutId: Int
        get() = R.layout.fragment_message
    override val viewModel: BaseViewModel
        get() = ViewModelProviders.of(this).get(BaseViewModel::class.java)

    override fun onCreateStuff() {
        setMessageAdapter()

    }

    private fun setMessageAdapter() {
        rvMessages.layoutManager = LinearLayoutManager(mContext)
        messageAdapter = MessagesAdapter(mContext,msgList)
        rvMessages.adapter = messageAdapter
    }

    override fun initListeners() {
      btnForSurvay.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view!!.id){
          R.id.btnForSurvay ->{
              val intent = Intent(mContext,VerifySchoolActivity::class.java)
              startActivity(intent)
          }
        }
    }
}
