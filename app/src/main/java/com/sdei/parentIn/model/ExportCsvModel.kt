package com.sdei.parentIn.model

class ExportCsvModel : BaseModel {

     constructor(message: String) {
        super.message = message
    }

    constructor(statusCode: Int, message: String) {
        super.message = message
        super.statusCode = statusCode
    }


    var data: String? = null

}
