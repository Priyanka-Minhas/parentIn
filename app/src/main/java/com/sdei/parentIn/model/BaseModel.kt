package com.sdei.parentIn.model

import com.sdei.parentIn.interfaces.InterConst.CODE_ERROR

open class BaseModel {


    /**
     * statusCode : 200
     * message : Registration successful
     */

    var statusCode = CODE_ERROR
    var message: String = ""

    constructor() {
        this.statusCode = CODE_ERROR
        this.message = ""
    }

    constructor(message: String) {
        this.message = message
    }

    constructor(statusCode: Int, message: String){
        this.message = message
        this.statusCode = statusCode
    }
}
