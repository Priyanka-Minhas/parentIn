package com.sdei.parentIn.viewModel.teacher

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.sdei.parentIn.model.ClassModel
import com.sdei.parentIn.repositories.teacher.NewTeacherMessageRepository
import com.sdei.parentIn.viewModel.BaseViewModel

class NewTeacherMessageViewModel(application: Application) : BaseViewModel(application = application) {

    private val mRepository: NewTeacherMessageRepository = NewTeacherMessageRepository()

    private var mChildList: MutableLiveData<ArrayList<ClassModel.DataBean>>? = null

    fun getClassList(): MutableLiveData<ArrayList<ClassModel.DataBean>> {
        if (mChildList == null) {
            mChildList = MutableLiveData()
            mRepository.getClassList(getApplication()) {
                mChildList!!.value = it
            }
        }
        return mChildList as MutableLiveData<ArrayList<ClassModel.DataBean>>
    }

}