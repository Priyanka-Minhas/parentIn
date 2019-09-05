package com.sdei.parentIn.viewModel.parent

import android.app.Application
import com.sdei.parentIn.interfaces.InterConst
import com.sdei.parentIn.model.BaseModel
import com.sdei.parentIn.model.ChildModel
import com.sdei.parentIn.model.SchoolModel
import com.sdei.parentIn.model.TeacherModel
import com.sdei.parentIn.network.RetrofitClient
import com.sdei.parentIn.room.RoomDb
import com.sdei.parentIn.utils.getAppPref
import com.sdei.parentIn.utils.handleJson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditChildRepository {

    fun getSchoolList(application: Application, returnValue: (ArrayList<SchoolModel.DataBean>) -> Unit) {
        returnValue(RoomDb.getInstance(application).getDao().fetchSchoolList() as ArrayList<SchoolModel.DataBean>)
    }

    // make call to get school mDialoglist
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


    fun editChildApi(model: ChildModel.DataBean, returnValue: (BaseModel) -> Unit) {
        val requestModel = setchildRequestData(model)

        RetrofitClient.instance!!.updateChildbyParent(requestModel)
                .enqueue(object : Callback<BaseModel> {
                    override fun onFailure(call: Call<BaseModel>, t: Throwable) {
                        returnValue(BaseModel(t.message!!))
                    }

                    override fun onResponse(call: Call<BaseModel>, response: Response<BaseModel>) {
                        when {
                            response.body() != null -> returnValue(response.body()!!)
                            response.errorBody() != null -> {
                                val (statusCode, message) = handleJson(response.errorBody()!!.string())
                                returnValue(BaseModel(statusCode.toInt(), message))
                            }
                            else -> returnValue(BaseModel(response.code(), response.message().toString()))
                        }
                    }
                })
    }


    fun addChildApi(model: ChildModel.DataBean, returnValue: (BaseModel) -> Unit) {
        val requestModel = setchildRequestData(model)
        RetrofitClient.instance!!.addChildbyParent(requestModel)
                .enqueue(object : Callback<BaseModel> {
                    override fun onFailure(call: Call<BaseModel>, t: Throwable) {
                        returnValue(BaseModel(t.message!!))
                    }

                    override fun onResponse(call: Call<BaseModel>, response: Response<BaseModel>) {
                        when {
                            response.body() != null -> returnValue(response.body()!!)
                            response.errorBody() != null -> {
                                val (statusCode, message) = handleJson(response.errorBody()!!.string())
                                returnValue(BaseModel(statusCode.toInt(), message))
                            }
                            else -> returnValue(BaseModel(response.code(), response.message().toString()))
                        }
                    }
                })
    }

    private fun setchildRequestData(model: ChildModel.DataBean): ChildModel.DataBeanRequest {
        val requestModel = ChildModel.DataBeanRequest()

        requestModel._id = getAppPref().getString(InterConst.ID)!!

        requestModel.child = ChildModel.DataBeanRequest.ChildBean()

        requestModel.child.birthDate = model.birthDate
        requestModel.child._id = model._id
        requestModel.child.firstName = model.firstName
        requestModel.child.lastName = model.lastName
        requestModel.child.school = model.school
        requestModel.child.teacher = model.teacher

        requestModel.child.sameAddressAsStudent = model.sameAddressAsStudent
        requestModel.child.homeAddress = model.homeAddress

        requestModel.child.verificationCard = model.verificationCard
        requestModel.child.gender = model.gender
        return requestModel
    }

}