package com.sdei.parentIn.repositories

import com.sdei.parentIn.model.BaseModel
import com.sdei.parentIn.model.UserModel
import com.sdei.parentIn.network.RetrofitClient
import com.sdei.parentIn.utils.hideProgress
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
                if (response!!.body() == null) {
                    returnValue(UserModel(response.errorBody()!!.string() as BaseModel))
                } else {
                    returnValue(response.body()!!)
                }
            }
        })
    }

}