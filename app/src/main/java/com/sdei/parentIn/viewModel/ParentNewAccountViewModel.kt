package com.sdei.parentIn.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.sdei.parentIn.interfaces.UserModel
import com.sdei.parentIn.repositories.ParentNewAccountRepository

class ParentNewAccountViewModel(application: Application) : BaseViewModel(application = application) {

    private val mRepository: ParentNewAccountRepository = ParentNewAccountRepository()

    private var mUserModel: MutableLiveData<UserModel>? = null

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


}