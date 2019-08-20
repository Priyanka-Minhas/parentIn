package com.sdei.parentIn.repositories

import com.sdei.parentIn.model.BaseModel
import com.sdei.parentIn.network.RetrofitClient
import com.sdei.parentIn.utils.hideProgress
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository() {

    fun login(email: String, password: String): BaseModel {

        var mModel = BaseModel()

        RetrofitClient.instance!!.login(email, password).enqueue(object : Callback<BaseModel> {
            override fun onFailure(call: Call<BaseModel>?, t: Throwable?) {
                hideProgress()
            }

            override fun onResponse(call: Call<BaseModel>?, response: Response<BaseModel>?) {
                hideProgress()
                mModel = response!!.body()!!
            }
        })
        return mModel
    }


}