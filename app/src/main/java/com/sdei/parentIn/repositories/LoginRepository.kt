package com.sdei.parentIn.repositories

import com.sdei.parentIn.model.UserModel
import com.sdei.parentIn.network.RetrofitClient
import com.sdei.parentIn.utils.hideProgress
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginRepository {

    fun login(email: String, password: String, roleId: Int, returnValue: (UserModel) -> Unit) {
        RetrofitClient.instance!!.login(email, password, roleId).enqueue(object : Callback<UserModel> {
            override fun onFailure(call: Call<UserModel>?, t: Throwable?) {
                hideProgress()
                returnValue(UserModel(t!!.message!!))
            }

            override fun onResponse(call: Call<UserModel>?, response: Response<UserModel>?) {
                hideProgress()
                if (response!!.body() != null) {
                    returnValue(response.body()!!)
                } else if(response.errorBody()!=null) {
                    val obj = JSONObject(response.errorBody()!!.string())
                    val statusCode = obj.getString("statusCode")
                    val message = obj.getString("message")

                    returnValue(UserModel(statusCode.toInt(),message.toString()))
                }else{
                    returnValue(UserModel(response.code(),response.message().toString()))
                }
            }
        })
    }

}