package com.sdei.parentIn.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.sdei.parentIn.model.SchoolModel
import com.sdei.parentIn.model.TeacherModel
import com.sdei.parentIn.model.UserModel
import com.sdei.parentIn.repositories.RegisterUserRepository

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

    fun hitTeacherListApi(schoolId: String, returnValue: (TeacherModel) -> Unit) {
        mRepository.getTeacherList(schoolId) {
            returnValue(it)
        }
    }
}