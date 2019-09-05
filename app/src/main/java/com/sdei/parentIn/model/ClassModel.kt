package com.sdei.parentIn.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

class ClassModel : BaseModel{
    var data = ArrayList<DataBean>()

    constructor(message: String) : super(message)

    constructor(statusCode: Int, message: String) {
        super.message = message
        super.statusCode = statusCode
    }
    @Entity(tableName = "ClassDataBean", indices = [Index(value = ["_id"], unique = true)])
    class DataBean{

        @PrimaryKey
        @NonNull
        var _id: String? = null
        var firstName: String? = null
        var lastName: String? = null
        var verificationCard: String? = null
        var gender: String? = null
        var birthDate: String? = null
        var isSurvey: Boolean? = null
        var school: String? = null
        var schoolName: String? = null
        var schoolAddress: String? = null
        var teacher: String? = null
        var teacherFirstName: String? = null
        var teacherLastName: String? = null
        var parent: String? = null
        var parentFirstName: String? = null
        var parentLastName: String? = null
        var parentEmailAddress: String? = null


    }

}