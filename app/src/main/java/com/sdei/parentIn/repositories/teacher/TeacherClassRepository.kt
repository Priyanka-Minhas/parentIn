package com.sdei.parentIn.repositories.teacher

import com.sdei.parentIn.model.ChildModel
import com.sdei.parentIn.model.ClassModel
import com.sdei.parentIn.network.RetrofitClient
import com.sdei.parentIn.utils.handleJson
import com.sdei.parentIn.utils.hideProgress
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeacherClassRepository {
    fun getClassApi(id: String, returnValue: (ClassModel) -> Unit) {
        RetrofitClient.instance!!.getClassByTeacher(id).enqueue(object : Callback<ClassModel> {
            override fun onFailure(call: Call<ClassModel>?, t: Throwable?) {
                hideProgress()
                returnValue(ClassModel(t!!.message!!))
            }
            override fun onResponse(call: Call<ClassModel>?, response: Response<ClassModel>?) {
                hideProgress()
                when {
                    response!!.body() != null -> returnValue(response.body()!!)
                    response.errorBody() != null -> {
                        val (statusCode, message) = handleJson(response.errorBody()!!.string())
                        returnValue(ClassModel(statusCode.toInt(), message))
                    }
                    else -> returnValue(ClassModel(response.code(), response.message().toString()))
                }
            }
        })

    }


}