package com.sdei.parentIn.repositories

import android.app.Application
import com.sdei.parentIn.model.SchoolModel
import com.sdei.parentIn.network.RetrofitClient
import com.sdei.parentIn.room.RoomDb
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WelcomeRepository {

    // make call to get school list
    fun getSchoolDataApi(application: Application) {
        RetrofitClient.instance!!.getSchoolList().enqueue(object : Callback<SchoolModel> {
            override fun onFailure(call: Call<SchoolModel>, t: Throwable) {
            }
            override fun onResponse(call: Call<SchoolModel>, response: Response<SchoolModel>) {
                if (response.body() != null) {
                    for (i in 0 until response.body()!!.data!!.size) {
                        RoomDb.getInstance(application)
                                .noteDao()
                                .insertSingleSchoolRecord(response.body()!!.data!![i])
                    }
                }
            }
        })
    }
}