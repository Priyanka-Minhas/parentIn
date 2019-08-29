package com.sdei.parentIn.activities

import android.content.Context
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.adapters.SurveysViewPagerAdapter
import com.sdei.parentIn.model.SurveysModel
import com.sdei.parentIn.utils.responseHandler
import com.sdei.parentIn.utils.showProgess
import com.sdei.parentIn.viewModel.SurveyViewModel
import kotlinx.android.synthetic.main.activity_survey.*

class SurveyActivity : BaseActivity<SurveyViewModel>() {

    override val viewModel: SurveyViewModel
        get() = ViewModelProviders.of(this).get(SurveyViewModel::class.java)

    override val context: Context
        get() = this@SurveyActivity

    override val layoutId: Int
        get() = R.layout.activity_survey

    var mSurveyList = ArrayList<SurveysModel.DataBean>()

    override fun onCreate() {
        showProgess()
        mViewModel!!.getSurveyList().observe(this,
                Observer<SurveysModel> { mData ->
                    if (mData != null && responseHandler(mData.statusCode, mData.message)) {
                        mSurveyList = mData.data!!
                        viewPager.adapter = SurveysViewPagerAdapter(this, mSurveyList)
                    }
                })
    }

    override fun initListeners() {

    }

}
