package com.sdei.parentIn.model

class ChildModel {

    var name: String = ""
    var gender: String = ""

    internal constructor() {

    }

    constructor(name: String, gender: String) {
        this.name = name
        this.gender = gender
    }


}
