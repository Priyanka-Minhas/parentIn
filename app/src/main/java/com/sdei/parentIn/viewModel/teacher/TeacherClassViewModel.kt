package com.sdei.parentIn.viewModel.teacher

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.sdei.parentIn.model.AddStudentManullyRequest
import com.sdei.parentIn.model.BaseModel
import com.sdei.parentIn.model.ClassModel
import com.sdei.parentIn.model.ExportCsvModel
import com.sdei.parentIn.repositories.teacher.TeacherClassRepository
import com.sdei.parentIn.viewModel.BaseViewModel

class TeacherClassViewModel(application: Application):BaseViewModel(application = application) {

    private val mRepository: TeacherClassRepository = TeacherClassRepository()


    private var mTeacherClassModel: MutableLiveData<ClassModel>? = null
    private var mAddStudent : MutableLiveData<BaseModel>? = null
    private var exportCsvLiveData : MutableLiveData<ExportCsvModel>? = null

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

    // add student

    fun sendRedToAddStudent(mData: AddStudentManullyRequest) {
        mRepository.addStudentApi(mData){
           mAddStudent!!.value =it
        }
    }

    fun getAddStudentStatus():MutableLiveData<BaseModel>{
        if(mAddStudent ==null){
           mAddStudent = MutableLiveData()
        }

        return  mAddStudent as MutableLiveData<BaseModel>
    }

    // export csv

    fun sendReqForCSVFile(id: String?): MutableLiveData<ExportCsvModel> {
        if (exportCsvLiveData == null) {
            exportCsvLiveData = MutableLiveData()
            mRepository.reqForCSV(id!!) {
                exportCsvLiveData!!.value =it
            }
        }

      return  exportCsvLiveData as MutableLiveData<ExportCsvModel>
    }

}