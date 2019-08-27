package com.sdei.parentIn.repositories

import com.sdei.parentIn.model.ChildModel
import com.sdei.parentIn.network.RetrofitClient
import com.sdei.parentIn.utils.handleJson
import com.sdei.parentIn.utils.hideProgress
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ParentLandingRepository {
    fun getChildApi(id: String, returnValue: (ChildModel) -> Unit) {
        RetrofitClient.instance!!.getChildList(id).enqueue(object : Callback<ChildModel> {
            override fun onFailure(call: Call<ChildModel>?, t: Throwable?) {
                hideProgress()
                returnValue(ChildModel(t!!.message!!))
            }
            override fun onResponse(call: Call<ChildModel>?, response: Response<ChildModel>?) {
                hideProgress()
                when {
                    response!!.body() != null -> returnValue(response.body()!!)
                    response.errorBody() != null -> {
                        val (statusCode, message) = handleJson(response.errorBody()!!.string())
                        returnValue(ChildModel(statusCode.toInt(), message))
                    }
                    else -> returnValue(ChildModel(response.code(), response.message().toString()))
                }
            }
        })

    }


}