package com.sdei.parentIn.repositories.teacher

import android.app.Application
import com.sdei.parentIn.model.ClassModel
import com.sdei.parentIn.room.RoomDb

class NewTeacherMessageRepository {
    fun getClassList(application: Application, returnValue: (ArrayList<ClassModel.DataBean>) -> Unit) {
        returnValue(RoomDb.getInstance(application).getDao().fetchTeacherClassList() as ArrayList<ClassModel.DataBean>)
    }

}