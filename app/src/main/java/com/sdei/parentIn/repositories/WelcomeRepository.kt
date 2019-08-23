package com.sdei.parentIn.repositories

import android.app.Application
import com.sdei.parentIn.interfaces.UserModel
import com.sdei.parentIn.model.SchoolListModel
import com.sdei.parentIn.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WelcomeRepository(application: Application) {

    // make call to get school list




    fun getSchoolData(returnValue: (SchoolListModel) -> Unit){
        RetrofitClient.instance!!.getSchoolList().enqueue(object :Callback<SchoolListModel>{
            override fun onFailure(call: Call<SchoolListModel>, t: Throwable) {
//                returnValue(SchoolListModel(t!!.message!!))
            }
            override fun onResponse(call: Call<SchoolListModel>, response: Response<SchoolListModel>) {
                returnValue(response!!.body()!!)
            }

        })

    }
}