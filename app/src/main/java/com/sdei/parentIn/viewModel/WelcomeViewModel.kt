package com.sdei.parentIn.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.sdei.parentIn.model.BaseModel

import com.sdei.parentIn.repositories.WelcomeRepository

class WelcomeViewModel(application: Application): BaseViewModel(application = application) {
    private val welcomeRepository  = WelcomeRepository()
    private var mUserModel: MutableLiveData<BaseModel>? = null

    fun getSchoolList(): MutableLiveData<BaseModel>{
        if (mUserModel == null) {
            mUserModel = MutableLiveData()
            welcomeRepository.getSchoolData {
                mUserModel!!.value =it
            }
        }
        return mUserModel as MutableLiveData<BaseModel>
    }

}