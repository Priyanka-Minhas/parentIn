package com.sdei.parentIn.viewModel.parent

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.sdei.parentIn.model.BaseModel
import com.sdei.parentIn.model.ChildModel
import com.sdei.parentIn.model.SchoolModel
import com.sdei.parentIn.model.TeacherModel
import com.sdei.parentIn.viewModel.BaseViewModel

class ParentEditChildViewModel(application: Application) : BaseViewModel(application = application) {

    private val mRepository: EditChildRepository = EditChildRepository()
    private var mSchoolList: MutableLiveData<ArrayList<SchoolModel.DataBean>>? = null

    private var mSuccessModel: MutableLiveData<BaseModel>? = null

    fun getSchoolList(): MutableLiveData<ArrayList<SchoolModel.DataBean>> {
        if (mSchoolList == null) {
            mSchoolList = MutableLiveData()
            mRepository.getSchoolList(application = getApplication()) {
                mSchoolList!!.value = it
            }
        }
        return mSchoolList as MutableLiveData<ArrayList<SchoolModel.DataBean>>
    }

    fun getChildUpdateStatus(): MutableLiveData<BaseModel> {
        if (mSuccessModel == null) {
            mSuccessModel = MutableLiveData()
        }
        return mSuccessModel as MutableLiveData<BaseModel>
    }


    fun hitTeacherListApi(schoolId: String, returnValue: (TeacherModel) -> Unit) {
        mRepository.getTeacherList(schoolId) {
            returnValue(it)
        }
    }

    fun hitChildUpdateApi(schoolId: ChildModel.DataBean) {
        mRepository.editChildApi(schoolId) {
            mSuccessModel!!.value = it
        }
    }

    fun hitChildAddApi(schoolId: ChildModel.DataBean) {
        mRepository.addChildApi(schoolId) {
            mSuccessModel!!.value = it
        }
    }


}
