package com.sdei.parentIn.repositories

import com.sdei.parentIn.model.UserModel
import com.sdei.parentIn.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ParentNewAccountRepository {

    fun register(model: UserModel.DataBean, returnValue: (UserModel) -> Unit) {
        RetrofitClient.instance!!.register(model).enqueue(object : Callback<UserModel> {
            override fun onFailure(call: Call<UserModel>?, t: Throwable?) {
                returnValue(UserModel(t!!.message!!))
            }

            override fun onResponse(call: Call<UserModel>?, response: Response<UserModel>?) {
                returnValue(response!!.body()!!)
            }
        })
    }
}