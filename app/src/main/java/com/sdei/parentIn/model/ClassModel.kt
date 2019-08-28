package com.sdei.parentIn.model
class ClassModel : BaseModel{
    //var data: ArrayList<DataBean?>? = null
    var data = ArrayList<DataBean>()

    constructor(message: String) : super(message)

    constructor(statusCode: Int, message: String) {
        super.message = message
        super.statusCode = statusCode
    }

    class DataBean{
        val id: String? = null
        val firstName: String? = null
        val lastName: String? = null
        val verificationCard: String? = null
        val gender: String? = null
        val birthDate: String? = null
        val isSurvey: Boolean? = null
        val school: String? = null
        val schoolName: String? = null
        val schoolAddress: String? = null
        val teacher: String? = null
        val teacherFirstName: String? = null
        val teacherLastName: String? = null
        val parent: String? = null
        val parentFirstName: String? = null
        val parentLastName: String? = null
        val parentEmailAddress: String? = null
    }

}