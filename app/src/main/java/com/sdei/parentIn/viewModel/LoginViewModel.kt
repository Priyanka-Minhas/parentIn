package com.sdei.parentIn.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.sdei.parentIn.model.UserModel
import com.sdei.parentIn.repositories.LoginRepository

class LoginViewModel(application: Application) : BaseViewModel(application = application) {

    private val mRepository: LoginRepository = LoginRepository()
    private var mUserModel: MutableLiveData<UserModel>? = null



    fun getUser(): MutableLiveData<UserModel> {
        if (mUserModel == null) {
            mUserModel = MutableLiveData()
        }
        return mUserModel as MutableLiveData<UserModel>
    }

    fun setLogin(email: String, password: String, roleId: Int) {
        mRepository.loginApi(email = email, password = password, roleId = roleId) {
            mUserModel!!.value = it
        }
    }

}


