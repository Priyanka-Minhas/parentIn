package com.sdei.parentIn.model;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SurveySchoolModel extends BaseModel {
    /**
     * statusCode : 200
     * data : [{"_id":"5d661f79320948394d423512","firstName":"Middle","lastName":"Devgan","verificationCard":"12312331","gender":"Female","birthDate":"2019-08-28","isSurvey":false,"school":"5d5e322baaa88c670cb0babb","schoolName":"Un Mundo Feliz","schoolAddress":"Dr. Juan T. Edye 1029, esquina J. de Viana, Maldonado, maldonado, Uruguay","parent":"5d661f79320948394d423511","parentFirstName":"Devgan","parentLastName":"Devgan","parentEmailAddress":"devgan@gmail.com"},{"_id":"5d6670f059e9b53b365fb402","firstName":"Chota333","lastName":"Devgan","verificationCard":"55555555","gender":"Male","birthDate":"2019-08-28","isSurvey":false,"school":"5d5e322baaa88c670cb0babb","schoolName":"Un Mundo Feliz","schoolAddress":"Dr. Juan T. Edye 1029, esquina J. de Viana, Maldonado, maldonado, Uruguay","parent":"5d661f79320948394d423511","parentFirstName":"Devgan","parentLastName":"Devgan","parentEmailAddress":"devgan@gmail.com"},{"_id":"5d667ac159e9b53b365fb408","firstName":"Sbsebda","lastName":"Devgan","verificationCard":"3423423","gender":"Male","birthDate":"2019-08-28","isSurvey":false,"school":"5d5e322baaa88c670cb0babb","schoolName":"Un Mundo Feliz","schoolAddress":"Dr. Juan T. Edye 1029, esquina J. de Viana, Maldonado, maldonado, Uruguay","parent":"5d661f79320948394d423511","parentFirstName":"Devgan","parentLastName":"Devgan","parentEmailAddress":"devgan@gmail.com"},{"_id":"5d667b3b59e9b53b365fb409","firstName":"Khatarnak","lastName":"Devgan","verificationCard":"3423423","gender":"Male","birthDate":"2019-08-28","isSurvey":false,"school":"5d5e322baaa88c670cb0babb","schoolName":"Un Mundo Feliz","schoolAddress":"Dr. Juan T. Edye 1029, esquina J. de Viana, Maldonado, maldonado, Uruguay","parent":"5d661f79320948394d423511","parentFirstName":"Devgan","parentLastName":"Devgan","parentEmailAddress":"devgan@gmail.com"},{"_id":"5d667bfb59e9b53b365fb40c","firstName":"Bohotbda","lastName":"Devgan","verificationCard":"23234123","gender":"Male","birthDate":"2019-08-28","isSurvey":false,"school":"5d5e322baaa88c670cb0babb","schoolName":"Un Mundo Feliz","schoolAddress":"Dr. Juan T. Edye 1029, esquina J. de Viana, Maldonado, maldonado, Uruguay","parent":"5d661f79320948394d423511","parentFirstName":"Devgan","parentLastName":"Devgan","parentEmailAddress":"devgan@gmail.com"},{"_id":"5d67609d59e9b53b365fb412","firstName":"Badhiya","lastName":"Devgan","verificationCard":"55555555","gender":"Male","birthDate":"2019-08-29","isSurvey":false,"school":"5d5e322baaa88c670cb0babb","schoolName":"Un Mundo Feliz","schoolAddress":"Dr. Juan T. Edye 1029, esquina J. de Viana, Maldonado, maldonado, Uruguay","parent":"5d661f79320948394d423511","parentFirstName":"Devgan","parentLastName":"Devgan","parentEmailAddress":"devgan@gmail.com"}]
     * message : Successful
     */

    private ArrayList<DataBean> data;

    public SurveySchoolModel(@NotNull String message) {
        super(message);

    }

    public SurveySchoolModel(int statusCode, @NotNull String message) {
        super(statusCode, message);
    }

    public ArrayList<DataBean> getData() {
        return data;
    }

    public void setData(ArrayList<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * _id : 5d661f79320948394d423512
         * firstName : Middle
         * lastName : Devgan
         * verificationCard : 12312331
         * gender : Female
         * birthDate : 2019-08-28
         * isSurvey : false
         * school : 5d5e322baaa88c670cb0babb
         * schoolName : Un Mundo Feliz
         * schoolAddress : Dr. Juan T. Edye 1029, esquina J. de Viana, Maldonado, maldonado, Uruguay
         * parent : 5d661f79320948394d423511
         * parentFirstName : Devgan
         * parentLastName : Devgan
         * parentEmailAddress : devgan@gmail.com
         */

        private String _id;
        private String firstName;
        private String lastName;
        private String verificationCard;
        private String gender;
        private String birthDate;
        private boolean isSurvey;
        private String school;
        private String schoolName;
        private String schoolAddress;
        private String parent;
        private String parentFirstName;
        private String parentLastName;
        private String parentEmailAddress;

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

        public boolean isIsSurvey() {
            return isSurvey;
        }

        public void setIsSurvey(boolean isSurvey) {
            this.isSurvey = isSurvey;
        }

        public String getSchool() {
            return school;
        }

        public void setSchool(String school) {
            this.school = school;
        }

        public String getSchoolName() {
            return schoolName;
        }

        public void setSchoolName(String schoolName) {
            this.schoolName = schoolName;
        }

        public String getSchoolAddress() {
            return schoolAddress;
        }

        public void setSchoolAddress(String schoolAddress) {
            this.schoolAddress = schoolAddress;
        }

        public String getParent() {
            return parent;
        }

        public void setParent(String parent) {
            this.parent = parent;
        }

        public String getParentFirstName() {
            return parentFirstName;
        }

        public void setParentFirstName(String parentFirstName) {
            this.parentFirstName = parentFirstName;
        }

        public String getParentLastName() {
            return parentLastName;
        }

        public void setParentLastName(String parentLastName) {
            this.parentLastName = parentLastName;
        }

        public String getParentEmailAddress() {
            return parentEmailAddress;
        }

        public void setParentEmailAddress(String parentEmailAddress) {
            this.parentEmailAddress = parentEmailAddress;
        }
    }
}
