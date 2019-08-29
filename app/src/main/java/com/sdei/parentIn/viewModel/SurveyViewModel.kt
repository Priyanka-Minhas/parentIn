package com.sdei.parentIn.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.sdei.parentIn.model.SurveysModel
import com.sdei.parentIn.repositories.SurveyRepository

class SurveyViewModel(application: Application) : BaseViewModel(application = application) {

    var mRepository: SurveyRepository = SurveyRepository()
    private var mSurveyModel: MutableLiveData<SurveysModel>? = null

    fun getSurveyList(): MutableLiveData<SurveysModel> {
        if (mSurveyModel == null) {
            mSurveyModel = MutableLiveData()
            mRepository.surveyListApi{
                mSurveyModel!!.value = it
            }
        }
        return mSurveyModel as MutableLiveData<SurveysModel>
    }

}