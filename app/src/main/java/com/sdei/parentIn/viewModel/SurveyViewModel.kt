package com.sdei.parentIn.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.sdei.parentIn.model.BaseModel
import com.sdei.parentIn.model.SurveysModel
import com.sdei.parentIn.repositories.SurveyRepository

class SurveyViewModel(application: Application) : BaseViewModel(application = application) {

    var mRepository: SurveyRepository = SurveyRepository()
    private var mSurveyModel: MutableLiveData<SurveysModel>? = null
    private var mSurveyAnswerModel: MutableLiveData<BaseModel>? = null

    fun getSurveyList(): MutableLiveData<SurveysModel> {
        if (mSurveyModel == null) {
            mSurveyModel = MutableLiveData()
            mRepository.surveyListApi{
                mSurveyModel!!.value = it
            }
        }
        return mSurveyModel as MutableLiveData<SurveysModel>
    }
   fun setSurveyResponse(): MutableLiveData<BaseModel> {
        if (mSurveyAnswerModel == null) {
            mSurveyAnswerModel = MutableLiveData()
        }
        return mSurveyAnswerModel as MutableLiveData<BaseModel>
    }

    fun saveSurvey(model: SurveysModel.DataBeanRequest) {
        mRepository.saveSurveyListApi(model) {
            mSurveyAnswerModel!!.value = it
        }
    }


}