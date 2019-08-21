package com.sdei.parentIn.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.sdei.parentIn.model.BaseModel
import com.sdei.parentIn.repositories.ParentNewAccountRepository

class ParentNewAccountViewModel(application: Application) : BaseViewModel(application = application) {

    private val mRepository: ParentNewAccountRepository = ParentNewAccountRepository()

    private var mUserModel: MutableLiveData<BaseModel>? = null

    fun getProfile(): MutableLiveData<BaseModel> {
        if (mUserModel == null) {
            mUserModel = MutableLiveData()
        }
        return mUserModel as MutableLiveData<BaseModel>
    }

    fun setProfile(email: String, password: String) {
        mRepository.login(email = email, password = password){
            mUserModel!!.value =it
        }
    }



}