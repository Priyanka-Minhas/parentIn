package com.sdei.parentIn.viewModel.teacher

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.sdei.parentIn.model.SchoolModel
import com.sdei.parentIn.model.UserModel
import com.sdei.parentIn.repositories.RegisterUserRepository
import com.sdei.parentIn.viewModel.BaseViewModel

class TeacherRegisterViewModel(application: Application) : BaseViewModel(application = application) {

    private val mRepository: RegisterUserRepository = RegisterUserRepository()
    private var mUserModel: MutableLiveData<UserModel>? = null
    private var mSchoolList: MutableLiveData<ArrayList<SchoolModel.DataBean>>? = null

    fun getProfile(): MutableLiveData<UserModel> {
        if (mUserModel == null) {
            mUserModel = MutableLiveData()
        }
        return mUserModel as MutableLiveData<UserModel>
    }

    fun getSchoolList(): MutableLiveData<ArrayList<SchoolModel.DataBean>> {
        if (mSchoolList == null) {
            mSchoolList = MutableLiveData()
            mRepository.getSchoolList(application = getApplication()) {
                mSchoolList!!.value = it
            }
        }
        return mSchoolList as MutableLiveData<ArrayList<SchoolModel.DataBean>>
    }

    fun setProfile(mModel: UserModel.DataBeanRequest) {
        mRepository.register(mModel) {
            mUserModel!!.value = it
        }
    }

}