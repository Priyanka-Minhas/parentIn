package com.sdei.parentIn.repositories

import android.app.Application
import com.sdei.parentIn.model.SchoolModel
import com.sdei.parentIn.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WelcomeRepository(application: Application) {

    // make call to get school list
    fun getSchoolData(returnValue: (SchoolModel) -> Unit){
        RetrofitClient.instance!!.getSchoolList().enqueue(object :Callback<SchoolModel>{
            override fun onFailure(call: Call<SchoolModel>, t: Throwable) {
//                returnValue(SchoolListModel(t!!.message!!))
            }
            override fun onResponse(call: Call<SchoolModel>, response: Response<SchoolModel>) {
                returnValue(response!!.body()!!)
            }

        })

    }
}