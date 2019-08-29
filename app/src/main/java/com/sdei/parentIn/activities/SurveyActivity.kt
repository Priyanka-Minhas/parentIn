package com.sdei.parentIn.activities

import android.content.Context
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.sdei.parentIn.R
import com.sdei.parentIn.adapters.SurveysViewPagerAdapter
import com.sdei.parentIn.model.SurveysModel
import com.sdei.parentIn.utils.responseHandler
import com.sdei.parentIn.utils.showProgess
import com.sdei.parentIn.viewModel.SurveyViewModel
import kotlinx.android.synthetic.main.activity_survey.*


class SurveyActivity : BaseActivity<SurveyViewModel>(), SurveysViewPagerAdapter.ClickInterface {
    override fun moveToBackSurvey(currentPosition: Int) {
        if (currentPosition != 0)
            vpSurveys.currentItem = currentPosition - 1
    }

    override fun moveToNextSurvey(currentPosition: Int) {
        if (currentPosition != mSurveyList.size)
            vpSurveys.currentItem = currentPosition + 1
    }

    override val viewModel: SurveyViewModel
        get() = ViewModelProviders.of(this).get(SurveyViewModel::class.java)

    override val context: Context
        get() = this@SurveyActivity

    override val layoutId: Int
        get() = R.layout.activity_survey

    var mSurveyList = ArrayList<SurveysModel.DataBean>()

    lateinit var mSurveyAdapter: SurveysViewPagerAdapter

    override fun onCreate() {
        setSurveyAdapter()

        showProgess()
        mViewModel!!.getSurveyList().observe(this,
                Observer<SurveysModel> { mData ->
                    if (mData != null && responseHandler(mData.statusCode, mData.message)) {
                        mSurveyList = mData.data!!
                        mSurveyAdapter.notifyList(mSurveyList)
                    }
                })

        vpSurveys.setPagingEnabled(false)

        vpSurveys.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                Log.d("onPageSelected", "LandingActivity$position")
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

    }

    private fun setSurveyAdapter() {
        mSurveyAdapter = SurveysViewPagerAdapter(this, mSurveyList, this)
        vpSurveys.adapter = mSurveyAdapter
    }

    override fun initListeners() {

    }

}
