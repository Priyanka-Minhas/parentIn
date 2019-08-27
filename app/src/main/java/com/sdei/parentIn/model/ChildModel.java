package com.sdei.parentIn.model;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ChildModel extends BaseModel {

    private ArrayList<DataBean> data;

    public ChildModel(@NotNull String message) {
        super(message);
    }

    public ChildModel(int statusCode, @NotNull String message) {
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
         * _id : 5d63b4558a53087261a09838
         * firstName : Demo
         * lastName : Student
         * verificationCard : 4598755
         * gender : M
         * birthDate : 11-10-1991
         * school : 5d5e322baaa88c670cb0babb
         * teacher : 5d5e35f6eacacc754b3dc7ba
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
