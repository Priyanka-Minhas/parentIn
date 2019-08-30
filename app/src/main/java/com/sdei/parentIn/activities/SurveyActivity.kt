package com.sdei.parentIn.activities

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.sdei.parentIn.R
import com.sdei.parentIn.adapters.SurveysViewPagerAdapter
import com.sdei.parentIn.interfaces.InterConst
import com.sdei.parentIn.model.BaseModel
import com.sdei.parentIn.model.SurveysModel
import com.sdei.parentIn.utils.getAppPref
import com.sdei.parentIn.utils.responseHandler
import com.sdei.parentIn.utils.showProgess
import com.sdei.parentIn.viewModel.SurveyViewModel
import kotlinx.android.synthetic.main.activity_survey.*


class SurveyActivity : BaseActivity<SurveyViewModel>(), SurveysViewPagerAdapter.ClickInterface {

    override fun moveToBackSurvey(currentPosition: Int) {
        if (currentPosition != 0) {
            mSurveyListAnswer.removeAt(currentPosition-1)
            vpSurveys.currentItem = currentPosition - 1
        }
    }

    override fun moveToNextSurvey(currentPosition: Int) {

        mSurveyListAnswer.add(SurveysModel.DataBeanRequest.SurveyBean(
                mSurveyList[currentPosition]._id,
                mSurveyList[currentPosition].answer,
                mSurveyList[currentPosition].answerPoints))

        if (currentPosition != mSurveyList.size - 1) {

            vpSurveys.currentItem = currentPosition + 1

        } else if (mSurveyList.size - 1 == currentPosition) {
            mSaveModel._id = getAppPref().getString(InterConst.ID)
            mSaveModel.childId = intent.getStringExtra(InterConst.CHILD_ID)
            mSaveModel.survey = mSurveyListAnswer
            for (i in 0 until mSurveyListAnswer.size) {
                mSaveModel.surveyPoints = mSaveModel.surveyPoints + mSurveyListAnswer[i].point
            }
            showProgess()
            mViewModel!!.saveSurvey(mSaveModel)
        }

    }

    override val viewModel: SurveyViewModel
        get() = ViewModelProviders.of(this).get(SurveyViewModel::class.java)

    override val context: Context
        get() = this@SurveyActivity

    override val layoutId: Int
        get() = R.layout.activity_survey

    var mSurveyList = ArrayList<SurveysModel.DataBean>()
    var mSurveyListAnswer = ArrayList<SurveysModel.DataBeanRequest.SurveyBean>()
    var mSaveModel = SurveysModel.DataBeanRequest()
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

        mViewModel!!.setSurveyResponse().observe(this,
                Observer<BaseModel> { mData ->
                    if (mData != null && responseHandler(mData.statusCode, mData.message)) {
                        setResult(Activity.RESULT_OK)
                        finish()
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
