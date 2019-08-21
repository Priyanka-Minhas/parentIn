package com.sdei.parentIn.model

class UserModel : BaseModel {

    constructor(message: String) {
        super.message = message
    }

    /**
     * statusCode : 200
     * data : {"_id":"5d5cee72254b342ebe39f4d5","firstName":"Lucifer","lastName":"Morningstar","phoneNumber":"8699826276","relationWithChild":"Guardian","homeAddress":"Top Floor, Lux, Los Angeles","isSameAddressAsStudent":true,"levelOfEducation":"PHD","noOfStudents":1,"emailAddress":"abc@gmail.com","password":"123456789","roleId":3,"__v":0,"token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjZWxsX251bWJlciI6ImFiY0BnbWFpbC5jb20iLCJpYXQiOjE1NjYzNzE0ODksImV4cCI6MTU2NjQ1Nzg4OX0.ULjh2x390TXPdLcroY2JxugPe6So6mn6CUn3IcWUwYw"}
     * message : Exitoso
     */


    var data: DataBean? = null


    class DataBean {
        /**
         * _id : 5d5cee72254b342ebe39f4d5
         * firstName : Lucifer
         * lastName : Morningstar
         * phoneNumber : 8699826276
         * relationWithChild : Guardian
         * homeAddress : Top Floor, Lux, Los Angeles
         * isSameAddressAsStudent : true
         * levelOfEducation : PHD
         * noOfStudents : 1
         * emailAddress : abc@gmail.com
         * password : 123456789
         * roleId : 3
         * __v : 0
         * token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjZWxsX251bWJlciI6ImFiY0BnbWFpbC5jb20iLCJpYXQiOjE1NjYzNzE0ODksImV4cCI6MTU2NjQ1Nzg4OX0.ULjh2x390TXPdLcroY2JxugPe6So6mn6CUn3IcWUwYw
         */

        var _id: String? = null
        var firstName: String? = null
        var lastName: String? = null
        var phoneNumber: String? = null
        var relationWithChild: String? = null
        var homeAddress: String? = null
        var isIsSameAddressAsStudent: Boolean = false
        var levelOfEducation: String? = null
        var noOfStudents: Int = 0
        var emailAddress: String? = null
        var password: String? = null
        var roleId: Int = 0
        var __v: Int = 0
        var token: String? = null
    }
}
