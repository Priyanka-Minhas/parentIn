package com.sdei.parentIn.repositories

import com.sdei.parentIn.model.UserModel
import com.sdei.parentIn.network.RetrofitClient
import com.sdei.parentIn.utils.hideProgress
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository {

    fun login(email: String, password: String, returnValue: (UserModel) -> Unit) {
        RetrofitClient.instance!!.login(email, password,2).enqueue(object : Callback<UserModel> {
            override fun onFailure(call: Call<UserModel>?, t: Throwable?) {
                hideProgress()
                //returnValue(UserModel(t!!.message!!))
            }

            override fun onResponse(call: Call<UserModel>?, response: Response<UserModel>?) {
                 hideProgress()
               // Toast.makeText(appli, "Hi there! This is a Toast.", Toast.LENGTH_LONG).show()
                //showToast("")
                //Log.e("=========","gdfkgjkdlf "+response)
//                returnValue(response!!.body()!!)
            }
        })
    }

}