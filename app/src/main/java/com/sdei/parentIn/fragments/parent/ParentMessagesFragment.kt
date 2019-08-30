package com.sdei.parentIn.fragments.parent

import android.annotation.SuppressLint
import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.activities.SurveySelectSchoolActivity
import com.sdei.parentIn.fragments.BaseFragment
import com.sdei.parentIn.interfaces.InterConst
import com.sdei.parentIn.utils.connectedToInternet
import com.sdei.parentIn.utils.getAppPref
import com.sdei.parentIn.viewModel.BaseViewModel
import kotlinx.android.synthetic.main.fragment_parent_messages.*

class ParentMessagesFragment : BaseFragment<BaseViewModel>() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var instance: ParentMessagesFragment

        fun newInstance(): ParentMessagesFragment {
            instance = ParentMessagesFragment()
            return instance
        }
    }
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

        if (getAppPref().getInt(InterConst.ROLE_ID) == InterConst.ROLE_TEACHER) {
            cvSurvay.visibility = View.GONE
        }

    }

    override fun initListeners() {
    }

}