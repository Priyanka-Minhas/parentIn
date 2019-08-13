package com.sdei.parentIn.repositories

//package com.sdei.parentIn.repositories
//
//import android.app.Application
//import android.util.Log
//import androidx.lifecycle.MutableLiveData
//import com.sdi.joyers.data.UserModel
//import com.sdei.parentIn.network.RetrofitClient
//import com.sdei.parentIn.room.DaoAccess
//import com.sdei.parentIn.room.RoomDb
//import com.sdei.parentIn.utils.hideProgress
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//class UserRepository(application: Application) {
//    private val daoAccess: DaoAccess
//    private var mUserModel: MutableLiveData<UserModel>
//
//    init {
//        val database = RoomDb.getInstance(application)
//        daoAccess = database.noteDao()
//        mUserModel = MutableLiveData()
//    }
//
//
//    fun registerUser(email: String, password: String): UserModel? {
//        RetrofitClient.instance!!.register_user(email, password).enqueue(
//            object : Callback<UserModel> {
//                override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
//                    hideProgress()
//                    Log.d("mresponse", response.toString())
//                    mUserModel.value = response.body()
//                }
//
//                override fun onFailure(call: Call<UserModel>, t: Throwable) {
//                    Log.d("mresponse", t.toString())
//                    hideProgress()
//                }
//            })
//        return mUserModel.value
//    }
//
//}
