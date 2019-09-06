package com.sdei.parentIn.repositories

import com.sdei.parentIn.interfaces.InterConst
import com.sdei.parentIn.model.MessagesModel
import com.sdei.parentIn.network.RetrofitClient
import com.sdei.parentIn.utils.getAppPref
import com.sdei.parentIn.utils.handleJson
import com.sdei.parentIn.utils.hideProgress
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MessageSingleUserRepository {

    fun getSingleMessageApi(from:String,to:String,returnValue: (MessagesModel) -> Unit) {
        RetrofitClient.instance!!.getMessageForSingleUser(from,to).enqueue(object : Callback<MessagesModel> {
            override fun onFailure(call: Call<MessagesModel>?, t: Throwable?) {
                hideProgress()
                returnValue(MessagesModel(t!!.message!!))
            }

            override fun onResponse(call: Call<MessagesModel>?, response: Response<MessagesModel>?) {
                hideProgress()
                when {
                    response!!.body() != null -> returnValue(response.body()!!)
                    response.errorBody() != null -> {
                        val (statusCode, message) = handleJson(response.errorBody()!!.string())
                        returnValue(MessagesModel(statusCode.toInt(), message))
                    }
                    else -> returnValue(MessagesModel(response.code(), response.message().toString()))
                }
            }
        })
    }
}