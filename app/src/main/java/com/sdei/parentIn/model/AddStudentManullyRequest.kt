package com.sdei.parentIn.model

class AddStudentManullyRequest {

    /**
     * firstName : Lucifer
     * lastName : Morningstar
     * emailAddress : 1dsdfsdd1@11d.com
     * child : {"firstName":"Desdfsdfmo","lastName":"Namfsdfe","verificationCard":"4598755","gender":"M","birthDate":"11-10-1991","school":"5d5e322baaa88c670cb0babb","teacher":"5d5e35f6eacacc754b3dc7ba"}
     */

    var firstName: String? = null
    var lastName: String? = null
    var emailAddress: String? = null
    var child: ChildBean? = null

    class ChildBean {
        /**
         * firstName : Desdfsdfmo
         * lastName : Namfsdfe
         * verificationCard : 4598755
         * gender : M
         * birthDate : 11-10-1991
         * school : 5d5e322baaa88c670cb0babb
         * teacher : 5d5e35f6eacacc754b3dc7ba
         */

        var firstName: String? = null
        var lastName: String? = null
        var verificationCard: String? = null
        var gender: String? = null
        var birthDate: String? = null
        var school: String? = null
        var teacher: String? = null
    }
}
