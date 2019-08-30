package com.sdei.parentIn.repositories

import com.sdei.parentIn.interfaces.InterConst
import com.sdei.parentIn.model.SurveySchoolModel
import com.sdei.parentIn.network.RetrofitClient
import com.sdei.parentIn.utils.getAppPref
import com.sdei.parentIn.utils.handleJson
import com.sdei.parentIn.utils.hideProgress
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SurveySelectSchoolRepository {

    fun getSchoolApi(returnValue: (SurveySchoolModel) -> Unit) {
        RetrofitClient.instance!!.getSchoolListforSurvey(getAppPref().getString(InterConst.ID)!!).enqueue(object : Callback<SurveySchoolModel> {
            override fun onFailure(call: Call<SurveySchoolModel>?, t: Throwable?) {
                hideProgress()
                returnValue(SurveySchoolModel(t!!.message!!))
            }

            override fun onResponse(call: Call<SurveySchoolModel>?, response: Response<SurveySchoolModel>?) {
                hideProgress()
                when {
                    response!!.body() != null -> returnValue(response.body()!!)
                    response.errorBody() != null -> {
                        val (statusCode, message) = handleJson(response.errorBody()!!.string())
                        returnValue(SurveySchoolModel(statusCode.toInt(), message))
                    }
                    else -> returnValue(SurveySchoolModel(response.code(), response.message().toString()))
                }
            }
        })
    }


}