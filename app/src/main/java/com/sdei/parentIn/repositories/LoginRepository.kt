package com.sdei.parentIn.repositories

import com.sdei.parentIn.model.UserModel
import com.sdei.parentIn.network.RetrofitClient
import com.sdei.parentIn.utils.handleJson
import com.sdei.parentIn.utils.hideProgress
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginRepository {

    fun loginApi(email: String, password: String, roleId: Int, returnValue: (UserModel) -> Unit) {
        RetrofitClient.instance!!.login(email, password, roleId).enqueue(object : Callback<UserModel> {
            override fun onFailure(call: Call<UserModel>?, t: Throwable?) {
                hideProgress()
                returnValue(UserModel(t!!.message!!))
            }

            override fun onResponse(call: Call<UserModel>?, response: Response<UserModel>?) {
                hideProgress()
                when {
                    response!!.body() != null -> returnValue(response.body()!!)
                    response.errorBody() != null -> {
                        val (statusCode, message) = handleJson(response.errorBody()!!.string())
                        returnValue(UserModel(statusCode.toInt(), message))
                    }
                    else -> returnValue(UserModel(response.code(), response.message().toString()))
                }
            }
        })
    }




}