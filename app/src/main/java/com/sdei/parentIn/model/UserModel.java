package com.sdei.parentIn.model;


import android.os.Parcel;
import android.os.Parcelable;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class UserModel extends BaseModel implements Parcelable {

    /**
     * data : {"_id":"5d5f7fb41c7e4c024e5a2c7c","firstName":"Lucifer","lastName":"Morningstar","phoneNumber":"8699826276","relationWithChild":"Guardian","homeAddress":"Top Floor, Lux, Los Angeles","isSameAddressAsStudent":true,"levelOfEducation":"PHD","noOfStudents":1,"emailAddress":"abcde@gmail.com","password":"$2b$12$P/jtXSrlmxIW7y1V1IL8x.1QYqNjCR8HW4wwX3Rwiks416UmucQ36","roleId":2,"childs":[{"_id":"5d5f7fb41c7e4c024e5a2c7d","firstName":"Demo","lastName":"Name","verificationCard":"45983434755","gender":"M","birthDate":"11-10-1991","school":"5d5e322baaa88c670cb0babb","teacher":"5d5e7f8a439fae1351a2914b"}],"__v":0}
     */

    private DataBean data;

    public UserModel(@NotNull String message) {
        super(message);
    }

    public UserModel(@NotNull int statusCode, @NotNull String message) {
        super.setMessage(message);
        super.setStatusCode(statusCode);
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }


    public static class DataBean implements Parcelable {
        /**
         * _id : 5d5f7fb41c7e4c024e5a2c7c
         * firstName : Lucifer
         * lastName : Morningstar
         * phoneNumber : 8699826276
         * relationWithChild : Guardian
         * homeAddress : Top Floor, Lux, Los Angeles
         * isSameAddressAsStudent : true
         * levelOfEducation : PHD
         * noOfStudents : 1
         * emailAddress : abcde@gmail.com
         * password : $2b$12$P/jtXSrlmxIW7y1V1IL8x.1QYqNjCR8HW4wwX3Rwiks416UmucQ36
         * roleId : 2
         * childs : [{"_id":"5d5f7fb41c7e4c024e5a2c7d","firstName":"Demo","lastName":"Name","verificationCard":"45983434755","gender":"M","birthDate":"11-10-1991","school":"5d5e322baaa88c670cb0babb","teacher":"5d5e7f8a439fae1351a2914b"}]
         * __v : 0
         * token: "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjZWxsX251bWJlciI6ImFzd3dhc0Bhc2Fzd3cuY29tIiwiaWF0IjoxNTY2OTAwODUxfQ.disHOjYRtWv5QFPSjrJi9l_UC5Ta-_E5jRSWEttgWQQ"
         * noOfStudents : 1
         * verificationCard : 123123123123123
         * isSameAddressAsStudent : true
         */

        private String _id;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String relationWithChild;
        private String homeAddress;
        private String levelOfEducation;
        private int noOfStudents;
        private String emailAddress;
        private String password;
        private int roleId;
        private List<ChildsBean> childs;
        private String verificationCard;
        private String token;
        private boolean isSameAddressAsStudent;

        public boolean isSameAddressAsStudent() {
            return isSameAddressAsStudent;
        }

        public void setSameAddressAsStudent(boolean sameAddressAsStudent) {
            isSameAddressAsStudent = sameAddressAsStudent;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public DataBean() {

        }

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


        public List<ChildsBean> getChilds() {
            return childs;
        }

        public void setChilds(List<ChildsBean> childs) {
            this.childs = childs;
        }


        public String getVerificationCard() {
            return verificationCard;
        }

        public void setVerificationCard(String verificationCard) {
            this.verificationCard = verificationCard;
        }

        public boolean isIsSameAddressAsStudent() {
            return isSameAddressAsStudent;
        }

        public void setIsSameAddressAsStudent(boolean isSameAddressAsStudent) {
            this.isSameAddressAsStudent = isSameAddressAsStudent;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this._id);
            dest.writeString(this.firstName);
            dest.writeString(this.lastName);
            dest.writeString(this.phoneNumber);
            dest.writeString(this.relationWithChild);
            dest.writeString(this.homeAddress);
            dest.writeString(this.levelOfEducation);
            dest.writeInt(this.noOfStudents);
            dest.writeString(this.emailAddress);
            dest.writeString(this.password);
            dest.writeInt(this.roleId);
            dest.writeTypedList(this.childs);
            dest.writeString(this.verificationCard);
            dest.writeString(this.token);
            dest.writeByte(this.isSameAddressAsStudent ? (byte) 1 : (byte) 0);
        }

        protected DataBean(Parcel in) {
            this._id = in.readString();
            this.firstName = in.readString();
            this.lastName = in.readString();
            this.phoneNumber = in.readString();
            this.relationWithChild = in.readString();
            this.homeAddress = in.readString();
            this.levelOfEducation = in.readString();
            this.noOfStudents = in.readInt();
            this.emailAddress = in.readString();
            this.password = in.readString();
            this.roleId = in.readInt();
            this.childs = in.createTypedArrayList(ChildsBean.CREATOR);
            this.verificationCard = in.readString();
            this.token = in.readString();
            this.isSameAddressAsStudent = in.readByte() != 0;
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel source) {
                return new DataBean(source);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };
    }

    public static class DataBeanRequest implements Parcelable {
        /**
         * confirmEmail : s@g.com
         * password : 12345678
         * school : Smart
         * levelOfEducation : Doctorate
         * firstName : Wqeqw
         * noOfStudents : less than 50
         * verificationCard : 312
         * confirmPassword : 12345678
         * lastName : Wqeqwe
         * roleId : 2
         * emailAddress : s@g.com
         * childs : [{}]
         */

        private String confirmEmail;
        private String password;
        private String school;
        private String levelOfEducation;
        private String firstName;
        private String noOfStudents;
        private String verificationCard;
        private String confirmPassword;
        private String homeAddress;
        private boolean isSameAddressAsStudent = false;
        private String relationWithChild;
        private String gender;
        private String lastName;
        private int roleId;
        private String emailAddress;
        private ArrayList<ChildsBean> childs;

        public DataBeanRequest() {

        }

        public String getConfirmEmail() {
            return confirmEmail;
        }

        public void setConfirmEmail(String confirmEmail) {
            this.confirmEmail = confirmEmail;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getSchool() {
            return school;
        }

        public void setSchool(String school) {
            this.school = school;
        }

        public String getLevelOfEducation() {
            return levelOfEducation;
        }

        public void setLevelOfEducation(String levelOfEducation) {
            this.levelOfEducation = levelOfEducation;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getNoOfStudents() {
            return noOfStudents;
        }

        public void setNoOfStudents(String noOfStudents) {
            this.noOfStudents = noOfStudents;
        }

        public String getVerificationCard() {
            return verificationCard;
        }

        public void setVerificationCard(String verificationCard) {
            this.verificationCard = verificationCard;
        }

        public String getConfirmPassword() {
            return confirmPassword;
        }

        public void setConfirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
        }

        public String getHomeAddress() {
            return homeAddress;
        }

        public void setHomeAddress(String homeAddress) {
            this.homeAddress = homeAddress;
        }

        public boolean isSameAddressAsStudent() {
            return isSameAddressAsStudent;
        }

        public void setSameAddressAsStudent(boolean sameAddressAsStudent) {
            isSameAddressAsStudent = sameAddressAsStudent;
        }

        public String getRelationWithChild() {
            return relationWithChild;
        }

        public void setRelationWithChild(String relationWithChild) {
            this.relationWithChild = relationWithChild;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getRoleId() {
            return roleId;
        }

        public void setRoleId(int roleId) {
            this.roleId = roleId;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        public ArrayList<ChildsBean> getChilds() {
            return childs;
        }

        public void setChilds(ArrayList<ChildsBean> childs) {
            this.childs = childs;
        }


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.confirmEmail);
            dest.writeString(this.password);
            dest.writeString(this.school);
            dest.writeString(this.levelOfEducation);
            dest.writeString(this.firstName);
            dest.writeString(this.noOfStudents);
            dest.writeString(this.verificationCard);
            dest.writeString(this.confirmPassword);
            dest.writeString(this.homeAddress);
            dest.writeByte(this.isSameAddressAsStudent ? (byte) 1 : (byte) 0);
            dest.writeString(this.relationWithChild);
            dest.writeString(this.gender);
            dest.writeString(this.lastName);
            dest.writeInt(this.roleId);
            dest.writeString(this.emailAddress);
            dest.writeList(this.childs);
        }

        protected DataBeanRequest(Parcel in) {
            this.confirmEmail = in.readString();
            this.password = in.readString();
            this.school = in.readString();
            this.levelOfEducation = in.readString();
            this.firstName = in.readString();
            this.noOfStudents = in.readString();
            this.verificationCard = in.readString();
            this.confirmPassword = in.readString();
            this.homeAddress = in.readString();
            this.isSameAddressAsStudent = in.readByte() != 0;
            this.relationWithChild = in.readString();
            this.gender = in.readString();
            this.lastName = in.readString();
            this.roleId = in.readInt();
            this.emailAddress = in.readString();
            this.childs = new ArrayList<ChildsBean>();
            in.readList(this.childs, ChildsBean.class.getClassLoader());
        }

        public static final Creator<DataBeanRequest> CREATOR = new Creator<DataBeanRequest>() {
            @Override
            public DataBeanRequest createFromParcel(Parcel source) {
                return new DataBeanRequest(source);
            }

            @Override
            public DataBeanRequest[] newArray(int size) {
                return new DataBeanRequest[size];
            }
        };
    }


    public static class ChildsBean implements Parcelable {
        /**
         * _id : 5d5f7fb41c7e4c024e5a2c7d
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
        private String school_name;
        private String teacher_name;

        public String getSchool_name() {
            return school_name;
        }

        public void setSchool_name(String school_name) {
            this.school_name = school_name;
        }

        public String getTeacher_name() {
            return teacher_name;
        }

        public void setTeacher_name(String teacher_name) {
            this.teacher_name = teacher_name;
        }

        public ChildsBean() {

        }

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


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this._id);
            dest.writeString(this.firstName);
            dest.writeString(this.lastName);
            dest.writeString(this.verificationCard);
            dest.writeString(this.gender);
            dest.writeString(this.birthDate);
            dest.writeString(this.school);
            dest.writeString(this.teacher);
            dest.writeString(this.school_name);
            dest.writeString(this.teacher_name);
        }

        protected ChildsBean(Parcel in) {
            this._id = in.readString();
            this.firstName = in.readString();
            this.lastName = in.readString();
            this.verificationCard = in.readString();
            this.gender = in.readString();
            this.birthDate = in.readString();
            this.school = in.readString();
            this.teacher = in.readString();
            this.school_name = in.readString();
            this.teacher_name = in.readString();
        }

        public static final Creator<ChildsBean> CREATOR = new Creator<ChildsBean>() {
            @Override
            public ChildsBean createFromParcel(Parcel source) {
                return new ChildsBean(source);
            }

            @Override
            public ChildsBean[] newArray(int size) {
                return new ChildsBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.data, flags);
    }

    protected UserModel(Parcel in) {
        this.data = in.readParcelable(DataBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<UserModel> CREATOR = new Parcelable.Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel source) {
            return new UserModel(source);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };
}
