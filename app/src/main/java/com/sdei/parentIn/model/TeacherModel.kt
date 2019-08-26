package com.sdei.parentIn.model

import java.util.*

class TeacherModel : BaseModel {

    var data: ArrayList<DataBean>? = null

    /**
     * statusCode : 200
     * data : [{"_id":"5d5e85d3f08e701b06e656ee","firstName":"Lucifer","lastName":"Morningstar","phoneNumber":"8699826276","relationWithChild":"Guardian","homeAddress":"Top Floor, Lux, Los Angeles","isSameAddressAsStudent":true,"levelOfEducation":"PHD","noOfStudents":1,"emailAddress":"asadds@asddas.com","password":"$2b$12$pZdxx2RegCUHC7XG5cgvcOiBeY/CiqOYaXwyQyuO9437OUZxuiSVC","roleId":3,"school":"5d5e322baaa88c670cb0babb","childs":[{"_id":"5d5e85d3f08e701b06e656ef","firstName":"Demo","lastName":"Name","verificationCard":"45983434755","gender":"M","birthDate":"11-10-1991","school":"5d5e322baaa88c670cb0babb","teacher":"5d5e7f8a439fae1351a2914b"}],"__v":0},{"_id":"5d5e85e7f08e701b06e656f0","firstName":"Lucifer","lastName":"Morningstar","phoneNumber":"8699826276","relationWithChild":"Guardian","homeAddress":"Top Floor, Lux, Los Angeles","isSameAddressAsStudent":true,"levelOfEducation":"PHD","noOfStudents":1,"emailAddress":"asdsdfsadds@asdsdfsdas.com","password":"$2b$12$nJavN4oj6fEXMVWl3vtUL.XMC54y8tH1t0oBnFsB/O6y/62i1ODNG","roleId":3,"school":"5d5e322baaa88c670cb0babb","childs":[{"_id":"5d5e85e7f08e701b06e656f1","firstName":"Demo","lastName":"Name","verificationCard":"45983434755","gender":"M","birthDate":"11-10-1991","school":"5d5e322baaa88c670cb0babb","teacher":"5d5e7f8a439fae1351a2914b"}],"__v":0},{"_id":"5d5f7c3c1c7e4c024e5a2c79","firstName":"James","lastName":"Bond","phoneNumber":"123456789","relationWithChild":"Guardian","homeAddress":"Top Floor, Lux, Los Angeles","isSameAddressAsStudent":true,"levelOfEducation":"PHD","noOfStudents":1,"emailAddress":"b@b.com","password":"$2b$12$8.CWTTsQ7D2Z7ikzk8vt0OYxc7ed/peHxFMsS/AIXSlTkrYq.ef8m","roleId":3,"school":"5d5e322baaa88c670cb0babb","childs":[{"_id":"5d5f7c3c1c7e4c024e5a2c7a","firstName":"Demo","lastName":"Name","verificationCard":"45983434755","gender":"M","birthDate":"11-10-1991","school":"5d5e322baaa88c670cb0babb","teacher":"5d5e7f8a439fae1351a2914b"}],"__v":0},{"_id":"5d5f7f5d1c7e4c024e5a2c7b","firstName":"Lucifer","lastName":"Morningstar","phoneNumber":"8699826276","relationWithChild":"Guardian","homeAddress":"Top Floor, Lux, Los Angeles","isSameAddressAsStudent":true,"levelOfEducation":"PHD","noOfStudents":1,"emailAddress":"asass@asasss.com","password":"$2b$12$2od5PfB1JWfgtHnNB9parOkwbjmP2LDrecoo1dhp82UlN6tJ7my0.","roleId":3,"school":"5d5e322baaa88c670cb0babb","childs":[],"__v":0},{"_id":"5d5f93991c7e4c024e5a2c80","firstName":"Lucifer","lastName":"Morningstar","phoneNumber":"8699826276","relationWithChild":"Guardian","homeAddress":"Top Floor, Lux, Los Angeles","isSameAddressAsStudent":true,"levelOfEducation":"PHD","noOfStudents":1,"emailAddress":"aswwas@asasww.com","password":"$2b$12$Az/Do.h0q9AnazQQ5otXBeqq7CIntFqeGn11UbM/T1MtvnNo3I0cS","roleId":2,"school":"5d5e322baaa88c670cb0babb","childs":[{"_id":"5d5f93991c7e4c024e5a2c81","firstName":"Demo","lastName":"Name","verificationCard":"45983434755","gender":"M","birthDate":"11-10-1991","school":"5d5e322baaa88c670cb0babb","teacher":"5d5e7f8a439fae1351a2914b"}],"__v":0},{"_id":"5d5fa4091c7e4c024e5a2c88","firstName":"James","lastName":"Bond","phoneNumber":"123456789","relationWithChild":"Guardian","homeAddress":"Top Floor, Lux, Los Angeles","isSameAddressAsStudent":true,"levelOfEducation":"PHD","noOfStudents":1,"emailAddress":"bd@b.com","password":"$2b$12$bHnoZc68gFWuX1UJGYF8.ukuw6NoYPCFlHVUjnjIfSxFQrjVA9/0G","roleId":3,"school":"5d5e322baaa88c670cb0babb","childs":[],"__v":0},{"_id":"5d5fa87f1c7e4c024e5a2c8d","firstName":"Lucifer","lastName":"Morningstar","phoneNumber":"8699826276","relationWithChild":"Guardian","homeAddress":"Top Floor, Lux, Los Angeles","isSameAddressAsStudent":true,"levelOfEducation":"PHD","noOfStudents":1,"emailAddress":"asassdds@asas.com","password":"$2b$12$cC.Pz1FHvBlw/MF85Jw5Zue0QgykRKdmyiZQvBIqgAStEWCe/WN1C","roleId":3,"school":"5d5e322baaa88c670cb0babb","childs":[{"_id":"5d5fa87f1c7e4c024e5a2c8e","firstName":"Demo","lastName":"Name","verificationCard":"45983434755","gender":"M","birthDate":"11-10-1991","school":"5d5e322baaa88c670cb0babb","teacher":"5d5e7f8a439fae1351a2914b"}],"__v":0},{"_id":"5d5fa8a01c7e4c024e5a2c8f","firstName":"Lucifer","lastName":"Morningstar","phoneNumber":"8699826276","relationWithChild":"Guardian","homeAddress":"Top Floor, Lux, Los Angeles","isSameAddressAsStudent":true,"levelOfEducation":"PHD","noOfStudents":1,"emailAddress":"asassewdds@asas.com","password":"$2b$12$lQzWf8ncgun9QYKkOTUGYe5qDaJthGuNGEhLop7yp3rc5pFUk1e7a","roleId":3,"school":"5d5e322baaa88c670cb0babb","childs":[],"__v":0},{"_id":"5d5fabe91aea2a22d6b3478d","firstName":"Wqeqw","lastName":"Wqeqwe","levelOfEducation":"Doctorate","noOfStudents":50,"emailAddress":"s@g.com","password":"$2b$12$1Hpn2OjZyvbc1mZwwoUvLuXQWCsC7DVLJLmpzlkETTyGqyMgyfjuC","roleId":3,"school":"5d5e322baaa88c670cb0babb","childs":[],"__v":0}]
     * message : Exitoso
     */

    constructor(message: String) : super(message)

    constructor(statusCode: Int, message: String) {
        super.message = message
        super.statusCode = statusCode
    }

    class DataBean {
        /**
         * _id : 5d5e85d3f08e701b06e656ee
         * firstName : Lucifer
         * lastName : Morningstar
         * phoneNumber : 8699826276
         * relationWithChild : Guardian
         * homeAddress : Top Floor, Lux, Los Angeles
         * isSameAddressAsStudent : true
         * levelOfEducation : PHD
         * noOfStudents : 1
         * emailAddress : asadds@asddas.com
         * password : $2b$12$pZdxx2RegCUHC7XG5cgvcOiBeY/CiqOYaXwyQyuO9437OUZxuiSVC
         * roleId : 3
         * school : 5d5e322baaa88c670cb0babb
         * childs : [{"_id":"5d5e85d3f08e701b06e656ef","firstName":"Demo","lastName":"Name","verificationCard":"45983434755","gender":"M","birthDate":"11-10-1991","school":"5d5e322baaa88c670cb0babb","teacher":"5d5e7f8a439fae1351a2914b"}]
         * __v : 0
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
        var school: String? = null
        var __v: Int = 0
        var childs: ArrayList<ChildsBean>? = null

        class ChildsBean {
            /**
             * _id : 5d5e85d3f08e701b06e656ef
             * firstName : Demo
             * lastName : Name
             * verificationCard : 45983434755
             * gender : M
             * birthDate : 11-10-1991
             * school : 5d5e322baaa88c670cb0babb
             * teacher : 5d5e7f8a439fae1351a2914b
             */

            var _id: String? = null
            var firstName: String? = null
            var lastName: String? = null
            var verificationCard: String? = null
            var gender: String? = null
            var birthDate: String? = null
            var school: String? = null
            var teacher: String? = null
        }
    }
}
