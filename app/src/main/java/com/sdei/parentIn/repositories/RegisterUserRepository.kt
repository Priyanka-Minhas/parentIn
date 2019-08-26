package com.sdei.parentIn.repositories

import android.app.Application
import com.sdei.parentIn.model.SchoolModel
import com.sdei.parentIn.model.TeacherModel
import com.sdei.parentIn.model.UserModel
import com.sdei.parentIn.network.RetrofitClient
import com.sdei.parentIn.room.RoomDb
import com.sdei.parentIn.utils.handleJson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterUserRepository {

    fun register(model: UserModel.DataBeanRequest, returnValue: (UserModel) -> Unit) {
        RetrofitClient.instance!!.register(model).enqueue(object : Callback<UserModel> {
            override fun onFailure(call: Call<UserModel>?, t: Throwable?) {
                returnValue(UserModel(t!!.message!!))
            }

            override fun onResponse(call: Call<UserModel>?, response: Response<UserModel>?) {
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

    // make call to get school list
    fun getTeacherList(schoolId: String, returnValue: (TeacherModel) -> Unit) {
        RetrofitClient.instance!!.teacherListBySchool(schoolId).enqueue(object : Callback<TeacherModel> {
            override fun onFailure(call: Call<TeacherModel>, t: Throwable) {
                returnValue(TeacherModel(t.message!!))
            }

            override fun onResponse(call: Call<TeacherModel>, response: Response<TeacherModel>) {
                when {
                    response.body() != null -> returnValue(response.body()!!)
                    response.errorBody() != null -> {
                        val (statusCode, message) = handleJson(response.errorBody()!!.string())
                        returnValue(TeacherModel(statusCode.toInt(), message))
                    }
                    else -> returnValue(TeacherModel(response.code(), response.message().toString()))
                }
            }

        })
    }

    fun getSchoolList(application: Application, returnValue: (ArrayList<SchoolModel.DataBean>) -> Unit) {
        returnValue(RoomDb.getInstance(application).noteDao().fetchSchoolList() as ArrayList<SchoolModel.DataBean>)
    }

}