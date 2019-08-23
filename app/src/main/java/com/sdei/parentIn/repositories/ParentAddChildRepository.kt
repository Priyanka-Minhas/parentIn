package com.sdei.parentIn.repositories
import com.sdei.parentIn.model.SchoolModel
import com.sdei.parentIn.model.UserModel
import com.sdei.parentIn.network.RetrofitClient
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ParentAddChildRepository {


    fun register(model: UserModel.DataBean, returnValue: (UserModel) -> Unit) {
        RetrofitClient.instance!!.register(model).enqueue(object : Callback<UserModel> {
            override fun onFailure(call: Call<UserModel>?, t: Throwable?) {
                returnValue(UserModel(t!!.message!!))
            }

            override fun onResponse(call: Call<UserModel>?, response: Response<UserModel>?) {
                if (response!!.body() != null) {
                    returnValue(response.body()!!)
                } else if(response.errorBody()!=null) {

                    val obj = JSONObject(response.errorBody()!!.string())

                    val statusCode = obj.getString("statusCode")
                    val message = obj.getString("message")

                    returnValue(UserModel(statusCode.toInt(),message.toString()))

                }else{
                    returnValue(UserModel(response.code(),response.message().toString()))
                }
            }
        })
    }

    // make call to get school list
    fun getSchoolData(returnValue: (SchoolModel) -> Unit){
        RetrofitClient.instance!!.getSchoolList().enqueue(object :Callback<SchoolModel>{
            override fun onFailure(call: Call<SchoolModel>, t: Throwable) {
                returnValue(SchoolModel(t!!.message!!))
            }

            override fun onResponse(call: Call<SchoolModel>, response: Response<SchoolModel>) {
                if (response!!.body() != null) {
                    returnValue(response.body()!!)
                } else if(response.errorBody()!=null) {

                    val obj = JSONObject(response.errorBody()!!.string())

                    val statusCode = obj.getString("statusCode")
                    val message = obj.getString("message")

                    returnValue(SchoolModel(statusCode.toInt(),message.toString()))

                }else{
                    returnValue(SchoolModel(response.code(),response.message().toString()))
                }
            }

        })

    }



}