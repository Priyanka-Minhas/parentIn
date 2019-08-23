package com.sdei.parentIn.model;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class TeacherModel extends BaseModel {


    private ArrayList<DataBean> data;

    /**
     * statusCode : 200
     * data : [{"_id":"5d5e85d3f08e701b06e656ee","firstName":"Lucifer","lastName":"Morningstar","phoneNumber":"8699826276","relationWithChild":"Guardian","homeAddress":"Top Floor, Lux, Los Angeles","isSameAddressAsStudent":true,"levelOfEducation":"PHD","noOfStudents":1,"emailAddress":"asadds@asddas.com","password":"$2b$12$pZdxx2RegCUHC7XG5cgvcOiBeY/CiqOYaXwyQyuO9437OUZxuiSVC","roleId":3,"school":"5d5e322baaa88c670cb0babb","childs":[{"_id":"5d5e85d3f08e701b06e656ef","firstName":"Demo","lastName":"Name","verificationCard":"45983434755","gender":"M","birthDate":"11-10-1991","school":"5d5e322baaa88c670cb0babb","teacher":"5d5e7f8a439fae1351a2914b"}],"__v":0},{"_id":"5d5e85e7f08e701b06e656f0","firstName":"Lucifer","lastName":"Morningstar","phoneNumber":"8699826276","relationWithChild":"Guardian","homeAddress":"Top Floor, Lux, Los Angeles","isSameAddressAsStudent":true,"levelOfEducation":"PHD","noOfStudents":1,"emailAddress":"asdsdfsadds@asdsdfsdas.com","password":"$2b$12$nJavN4oj6fEXMVWl3vtUL.XMC54y8tH1t0oBnFsB/O6y/62i1ODNG","roleId":3,"school":"5d5e322baaa88c670cb0babb","childs":[{"_id":"5d5e85e7f08e701b06e656f1","firstName":"Demo","lastName":"Name","verificationCard":"45983434755","gender":"M","birthDate":"11-10-1991","school":"5d5e322baaa88c670cb0babb","teacher":"5d5e7f8a439fae1351a2914b"}],"__v":0},{"_id":"5d5f7c3c1c7e4c024e5a2c79","firstName":"James","lastName":"Bond","phoneNumber":"123456789","relationWithChild":"Guardian","homeAddress":"Top Floor, Lux, Los Angeles","isSameAddressAsStudent":true,"levelOfEducation":"PHD","noOfStudents":1,"emailAddress":"b@b.com","password":"$2b$12$8.CWTTsQ7D2Z7ikzk8vt0OYxc7ed/peHxFMsS/AIXSlTkrYq.ef8m","roleId":3,"school":"5d5e322baaa88c670cb0babb","childs":[{"_id":"5d5f7c3c1c7e4c024e5a2c7a","firstName":"Demo","lastName":"Name","verificationCard":"45983434755","gender":"M","birthDate":"11-10-1991","school":"5d5e322baaa88c670cb0babb","teacher":"5d5e7f8a439fae1351a2914b"}],"__v":0},{"_id":"5d5f7f5d1c7e4c024e5a2c7b","firstName":"Lucifer","lastName":"Morningstar","phoneNumber":"8699826276","relationWithChild":"Guardian","homeAddress":"Top Floor, Lux, Los Angeles","isSameAddressAsStudent":true,"levelOfEducation":"PHD","noOfStudents":1,"emailAddress":"asass@asasss.com","password":"$2b$12$2od5PfB1JWfgtHnNB9parOkwbjmP2LDrecoo1dhp82UlN6tJ7my0.","roleId":3,"school":"5d5e322baaa88c670cb0babb","childs":[],"__v":0},{"_id":"5d5f93991c7e4c024e5a2c80","firstName":"Lucifer","lastName":"Morningstar","phoneNumber":"8699826276","relationWithChild":"Guardian","homeAddress":"Top Floor, Lux, Los Angeles","isSameAddressAsStudent":true,"levelOfEducation":"PHD","noOfStudents":1,"emailAddress":"aswwas@asasww.com","password":"$2b$12$Az/Do.h0q9AnazQQ5otXBeqq7CIntFqeGn11UbM/T1MtvnNo3I0cS","roleId":2,"school":"5d5e322baaa88c670cb0babb","childs":[{"_id":"5d5f93991c7e4c024e5a2c81","firstName":"Demo","lastName":"Name","verificationCard":"45983434755","gender":"M","birthDate":"11-10-1991","school":"5d5e322baaa88c670cb0babb","teacher":"5d5e7f8a439fae1351a2914b"}],"__v":0},{"_id":"5d5fa4091c7e4c024e5a2c88","firstName":"James","lastName":"Bond","phoneNumber":"123456789","relationWithChild":"Guardian","homeAddress":"Top Floor, Lux, Los Angeles","isSameAddressAsStudent":true,"levelOfEducation":"PHD","noOfStudents":1,"emailAddress":"bd@b.com","password":"$2b$12$bHnoZc68gFWuX1UJGYF8.ukuw6NoYPCFlHVUjnjIfSxFQrjVA9/0G","roleId":3,"school":"5d5e322baaa88c670cb0babb","childs":[],"__v":0},{"_id":"5d5fa87f1c7e4c024e5a2c8d","firstName":"Lucifer","lastName":"Morningstar","phoneNumber":"8699826276","relationWithChild":"Guardian","homeAddress":"Top Floor, Lux, Los Angeles","isSameAddressAsStudent":true,"levelOfEducation":"PHD","noOfStudents":1,"emailAddress":"asassdds@asas.com","password":"$2b$12$cC.Pz1FHvBlw/MF85Jw5Zue0QgykRKdmyiZQvBIqgAStEWCe/WN1C","roleId":3,"school":"5d5e322baaa88c670cb0babb","childs":[{"_id":"5d5fa87f1c7e4c024e5a2c8e","firstName":"Demo","lastName":"Name","verificationCard":"45983434755","gender":"M","birthDate":"11-10-1991","school":"5d5e322baaa88c670cb0babb","teacher":"5d5e7f8a439fae1351a2914b"}],"__v":0},{"_id":"5d5fa8a01c7e4c024e5a2c8f","firstName":"Lucifer","lastName":"Morningstar","phoneNumber":"8699826276","relationWithChild":"Guardian","homeAddress":"Top Floor, Lux, Los Angeles","isSameAddressAsStudent":true,"levelOfEducation":"PHD","noOfStudents":1,"emailAddress":"asassewdds@asas.com","password":"$2b$12$lQzWf8ncgun9QYKkOTUGYe5qDaJthGuNGEhLop7yp3rc5pFUk1e7a","roleId":3,"school":"5d5e322baaa88c670cb0babb","childs":[],"__v":0},{"_id":"5d5fabe91aea2a22d6b3478d","firstName":"Wqeqw","lastName":"Wqeqwe","levelOfEducation":"Doctorate","noOfStudents":50,"emailAddress":"s@g.com","password":"$2b$12$1Hpn2OjZyvbc1mZwwoUvLuXQWCsC7DVLJLmpzlkETTyGqyMgyfjuC","roleId":3,"school":"5d5e322baaa88c670cb0babb","childs":[],"__v":0}]
     * message : Exitoso
     */

    public TeacherModel(@NotNull String message) {
        super(message);
    }

    public TeacherModel(@NotNull int statusCode, @NotNull String message) {
        super.setMessage(message);
        super.setStatusCode(statusCode);
    }

    public ArrayList<DataBean> getData() {
        return data;
    }

    public void setData(ArrayList<DataBean> data) {
        this.data = data;
    }


    public static class DataBean {
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

        private String _id;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String relationWithChild;
        private String homeAddress;
        private boolean isSameAddressAsStudent;
        private String levelOfEducation;
        private int noOfStudents;
        private String emailAddress;
        private String password;
        private int roleId;
        private String school;
        private int __v;
        private ArrayList<ChildsBean> childs;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getRelationWithChild() {
            return relationWithChild;
        }

        public void setRelationWithChild(String relationWithChild) {
            this.relationWithChild = relationWithChild;
        }

        public String getHomeAddress() {
            return homeAddress;
        }

        public void setHomeAddress(String homeAddress) {
            this.homeAddress = homeAddress;
        }

        public boolean isIsSameAddressAsStudent() {
            return isSameAddressAsStudent;
        }

        public void setIsSameAddressAsStudent(boolean isSameAddressAsStudent) {
            this.isSameAddressAsStudent = isSameAddressAsStudent;
        }

        public String getLevelOfEducation() {
            return levelOfEducation;
        }

        public void setLevelOfEducation(String levelOfEducation) {
            this.levelOfEducation = levelOfEducation;
        }

        public int getNoOfStudents() {
            return noOfStudents;
        }

        public void setNoOfStudents(int noOfStudents) {
            this.noOfStudents = noOfStudents;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getRoleId() {
            return roleId;
        }

        public void setRoleId(int roleId) {
            this.roleId = roleId;
        }

        public String getSchool() {
            return school;
        }

        public void setSchool(String school) {
            this.school = school;
        }

        public int get__v() {
            return __v;
        }

        public void set__v(int __v) {
            this.__v = __v;
        }

        public ArrayList<ChildsBean> getChilds() {
            return childs;
        }

        public void setChilds(ArrayList<ChildsBean> childs) {
            this.childs = childs;
        }

        public static class ChildsBean {
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

            private String _id;
            private String firstName;
            private String lastName;
            private String verificationCard;
            private String gender;
            private String birthDate;
            private String school;
            private String teacher;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            public String getLastName() {
                return lastName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }

            public String getVerificationCard() {
                return verificationCard;
            }

            public void setVerificationCard(String verificationCard) {
                this.verificationCard = verificationCard;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            public String getBirthDate() {
                return birthDate;
            }

            public void setBirthDate(String birthDate) {
                this.birthDate = birthDate;
            }

            public String getSchool() {
                return school;
            }

            public void setSchool(String school) {
                this.school = school;
            }

            public String getTeacher() {
                return teacher;
            }

            public void setTeacher(String teacher) {
                this.teacher = teacher;
            }
        }
    }
}
