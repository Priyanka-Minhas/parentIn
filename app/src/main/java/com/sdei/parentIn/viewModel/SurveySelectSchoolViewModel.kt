package com.sdei.parentIn.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.sdei.parentIn.model.SurveySchoolModel
import com.sdei.parentIn.repositories.SurveySelectSchoolRepository


class SurveySelectSchoolViewModel(application: Application) : BaseViewModel(application = application) {

    private val mRepository: SurveySelectSchoolRepository = SurveySelectSchoolRepository()
    private var mSchoolModel: MutableLiveData<SurveySchoolModel>? = null


    fun getSchoolList(): MutableLiveData<SurveySchoolModel> {
        if (mSchoolModel == null) {
            mSchoolModel = MutableLiveData()
            mRepository.getSchoolApi {
                mSchoolModel!!.value = it
            }
        }
        return mSchoolModel as MutableLiveData<SurveySchoolModel>
    }

}
