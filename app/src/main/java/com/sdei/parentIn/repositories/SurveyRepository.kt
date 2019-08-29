package com.sdei.parentIn.repositories

import com.sdei.parentIn.model.SurveysModel
import com.sdei.parentIn.network.RetrofitClient
import com.sdei.parentIn.utils.handleJson
import com.sdei.parentIn.utils.hideProgress
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SurveyRepository {

    fun surveyListApi(returnValue: (SurveysModel) -> Unit) {
        RetrofitClient.instance!!.getSurveyList().enqueue(object : Callback<SurveysModel> {
            override fun onFailure(call: Call<SurveysModel>?, t: Throwable?) {
                hideProgress()
                returnValue(SurveysModel(t!!.message!!))
            }

            override fun onResponse(call: Call<SurveysModel>?, response: Response<SurveysModel>?) {
                hideProgress()
                when {
                    response!!.body() != null -> returnValue(response.body()!!)
                    response.errorBody() != null -> {
                        val (statusCode, message) = handleJson(response.errorBody()!!.string())
                        returnValue(SurveysModel(statusCode.toInt(), message))
                    }
                    else -> returnValue(SurveysModel(response.code(), response.message().toString()))
                }
            }
        })

    }
}