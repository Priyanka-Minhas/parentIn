package com.sdei.parentIn.repositories.parent

import android.app.Application
import com.sdei.parentIn.model.ChildModel
import com.sdei.parentIn.room.RoomDb

class NewParentMessageRepository {
    fun getChildList(application: Application, returnValue: (ArrayList<ChildModel.DataBean>) -> Unit) {
        returnValue(RoomDb.getInstance(application).getDao().fetchParentChildList() as ArrayList<ChildModel.DataBean>)
    }

}