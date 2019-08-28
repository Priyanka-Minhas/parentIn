package com.sdei.parentIn.viewModel.teacher

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.sdei.parentIn.model.ClassModel
import com.sdei.parentIn.repositories.teacher.TeacherClassRepository
import com.sdei.parentIn.viewModel.BaseViewModel

class TeacherClassViewModel(application: Application):BaseViewModel(application = application) {

    private val mRepository: TeacherClassRepository = TeacherClassRepository()


    private var mTeacherClassModel: MutableLiveData<ClassModel>? = null

    fun getClass(): MutableLiveData<ClassModel> {
        if (mTeacherClassModel == null) {
            mTeacherClassModel = MutableLiveData()
        }
        return mTeacherClassModel as MutableLiveData<ClassModel>
    }

    fun hitClassListByTeacherApi(id:String) {
        mRepository.getClassApi(id) {
            mTeacherClassModel!!.value = it
        }
    }

}