package com.sdei.parentIn.fragments.parent

import android.annotation.SuppressLint
import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.activities.SurveySelectSchoolActivity
import com.sdei.parentIn.adapters.MessagesAdapter
import com.sdei.parentIn.fragments.BaseFragment
import com.sdei.parentIn.viewModel.BaseViewModel
import kotlinx.android.synthetic.main.fragment_parent_messages.*

class ParentMessagesFragment : BaseFragment<BaseViewModel>(){
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var instance: ParentMessagesFragment

        fun newInstance(): ParentMessagesFragment {
            instance = ParentMessagesFragment()
            return instance
        }
    }

    var msgList = arrayListOf<String>()
    lateinit var messageAdapter: MessagesAdapter
    override val layoutId: Int
        get() = R.layout.fragment_parent_messages
    override val viewModel: BaseViewModel
        get() = ViewModelProviders.of(this).get(BaseViewModel::class.java)

    override fun onCreateStuff() {
        //setMessageAdapter()
//        btnForSurvay.setOnClickListener(this)

//        btnForSurvay.setOnClickListener {
//            //val intent = Intent(mContext,SurveySelectSchoolActivity::class.java)
//            //startActivity(intent)
//
//            Log.e("===========","=======")
//        }

        btnForSurvay.setOnClickListener {
            val intent = Intent(mContext, SurveySelectSchoolActivity::class.java)
            startActivity(intent)
        }

    }

    private fun setMessageAdapter() {
//        rvMessages.layoutManager = LinearLayoutManager(mContext)
//        messageAdapter = MessagesAdapter(mContext,msgList)
//        rvMessages.adapter = messageAdapter
    }

    override fun initListeners() {
    }

}