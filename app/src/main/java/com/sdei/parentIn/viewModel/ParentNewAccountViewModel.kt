package com.sdei.parentIn.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.sdei.parentIn.model.SchoolModel
import com.sdei.parentIn.model.TeacherModel
import com.sdei.parentIn.model.UserModel
import com.sdei.parentIn.repositories.ParentAddChildRepository

class ParentNewAccountViewModel(application: Application) : BaseViewModel(application = application) {


    private val mRepository: ParentAddChildRepository = ParentAddChildRepository()

    private var mUserModel: MutableLiveData<UserModel>? = null
    // school model
    private var mSchoolModel: MutableLiveData<SchoolModel>? = null

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
    fun getSchoolList(): MutableLiveData<SchoolModel> {
        if (mSchoolModel == null) {
            mSchoolModel = MutableLiveData()
            mRepository.getSchoolData {
                mSchoolModel!!.value = it
            }
        }
        return mSchoolModel as MutableLiveData<SchoolModel>
    }

    // get Teacher list
    fun hitTeacherListApi(schoolId: String, returnValue: (TeacherModel) -> Unit) {
        mRepository.getTeacherList(schoolId) {
            returnValue(it)
        }
    }


}