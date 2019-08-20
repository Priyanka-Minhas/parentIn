package com.sdei.parentIn.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.sdei.parentIn.model.BaseModel
import com.sdei.parentIn.repositories.LoginRepository

class LoginViewModel(application: Application):BaseViewModel(application = application) {

    private val mRepository: LoginRepository = LoginRepository()

    private var mUserModel: MutableLiveData<BaseModel>? = null

    fun getUser(): MutableLiveData<BaseModel> {
        if (mUserModel == null) {
            mUserModel = MutableLiveData()
        }
        return mUserModel as MutableLiveData<BaseModel>
    }

    fun setLogin(email: String, password: String){
        mUserModel!!.value = mRepository.login(email = email, password = password)
    }

}