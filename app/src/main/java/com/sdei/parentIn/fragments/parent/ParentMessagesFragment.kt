package com.sdei.parentIn.fragments.parent

import android.annotation.SuppressLint
import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdei.parentIn.R
import com.sdei.parentIn.activities.SurveySelectSchoolActivity
import com.sdei.parentIn.adapters.ParentMessagesAdapter
import com.sdei.parentIn.adapters.ParentMessagesAdapter.*
import com.sdei.parentIn.dialog.MessageDialog
import com.sdei.parentIn.fragments.BaseFragment
import com.sdei.parentIn.utils.connectedToInternet
import com.sdei.parentIn.viewModel.BaseViewModel
import kotlinx.android.synthetic.main.fragment_parent_messages.*

class ParentMessagesFragment : BaseFragment<BaseViewModel>(){

    var list = arrayListOf<String>("Khem","Subham","C","D")
    lateinit var parentMsgAdapter : ParentMessagesAdapter
    var messageDialog : MessageDialog? = null
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

        /*if (getAppPref().getInt(InterConst.ROLE_ID) == InterConst.ROLE_TEACHER) {
            cvSurvay.visibility = View.GONE
        }*/

        // set adapter
        setParentMessageAdapter()
    }

    private fun setParentMessageAdapter() {
        rvParentMessages.layoutManager = LinearLayoutManager(mContext)
        rvParentMessages.adapter = ParentMessagesAdapter(mContext,list,object:Callback{
            override fun getIndex(pos: Int) {
             messageDialog = MessageDialog(mContext,R.style.pullBottomfromTop,R.layout.dialog_message)
             messageDialog!!.show()
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