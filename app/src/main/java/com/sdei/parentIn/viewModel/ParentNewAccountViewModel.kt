package com.sdei.parentIn.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.sdei.parentIn.model.BaseModel
import com.sdei.parentIn.model.SchoolModel
import com.sdei.parentIn.model.UserModel
import com.sdei.parentIn.repositories.ParentNewAccountRepository
import com.sdei.parentIn.repositories.WelcomeRepository

class ParentNewAccountViewModel(application: Application) : BaseViewModel(application = application) {

    private val mRepository: ParentNewAccountRepository = ParentNewAccountRepository()
    private val welcomeRepository:WelcomeRepository = WelcomeRepository()

    private var mUserModel: MutableLiveData<UserModel>? = null
    // school model
    private var mSchoolModel:MutableLiveData<SchoolModel>?=null

    fun getProfile(): MutableLiveData<UserModel> {
        if (mUserModel == null) {
            mUserModel = MutableLiveData()
        }
        return mUserModel as MutableLiveData<UserModel>
    }

    fun setProfile(mModel: UserModel.DataBean) {
        mRepository.register(mModel) {
            mUserModel!!.value = it
        }
    }

    // get school list

    fun getSchoolList(): MutableLiveData<SchoolModel>{
        if (mSchoolModel == null) {
            mSchoolModel = MutableLiveData()
            welcomeRepository.getSchoolData {
                mSchoolModel!!.value =it
            }
        }
        return mSchoolModel as MutableLiveData<SchoolModel>
    }


}