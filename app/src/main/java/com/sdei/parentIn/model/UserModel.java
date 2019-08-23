package com.sdei.parentIn.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class UserModel extends BaseModel implements Parcelable {


    /**
     * data : {"_id":"5d5f7fb41c7e4c024e5a2c7c","firstName":"Lucifer","lastName":"Morningstar","phoneNumber":"8699826276","relationWithChild":"Guardian","homeAddress":"Top Floor, Lux, Los Angeles","isSameAddressAsStudent":true,"levelOfEducation":"PHD","noOfStudents":1,"emailAddress":"abcde@gmail.com","password":"$2b$12$P/jtXSrlmxIW7y1V1IL8x.1QYqNjCR8HW4wwX3Rwiks416UmucQ36","roleId":2,"childs":[{"_id":"5d5f7fb41c7e4c024e5a2c7d","firstName":"Demo","lastName":"Name","verificationCard":"45983434755","gender":"M","birthDate":"11-10-1991","school":"5d5e322baaa88c670cb0babb","teacher":"5d5e7f8a439fae1351a2914b"}],"__v":0}
     */

    private DataBean data;

    public UserModel(@NotNull String message) {
        super(message);
    }

    public UserModel(@NotNull int statusCode,@NotNull String message) {
        super.setMessage(message);
        super.setStatusCode(statusCode);
    }

    protected UserModel(Parcel in) {
        data = in.readParcelable(DataBean.class.getClassLoader());
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(data, flags);
    }

    public static class DataBean implements Parcelable {
        public static final Creator CREATOR = new Creator() {
            public DataBean createFromParcel(Parcel in) {
                return new DataBean(in);
            }

            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };
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
        private int __v;
        private List<ChildsBean> childs;

        public DataBean(Parcel in) {
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
            this.__v = in.readInt();
            boolean[] temp = new boolean[1];
            in.readBooleanArray(temp);
            isSameAddressAsStudent = temp[0];
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

        public int get__v() {
            return __v;
        }

        public void set__v(int __v) {
            this.__v = __v;
        }

        public List<ChildsBean> getChilds() {
            return childs;
        }

        public void setChilds(List<ChildsBean> childs) {
            this.childs = childs;
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
            dest.writeInt(this.__v);
            dest.writeBooleanArray(new boolean[]{isSameAddressAsStudent});
        }



        public static class ChildsBean implements Parcelable {
            public static final Creator CREATOR = new Creator() {
                public ChildsBean createFromParcel(Parcel in) {
                    return new ChildsBean(in);
                }

                public ChildsBean[] newArray(int size) {
                    return new ChildsBean[size];
                }
            };
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
            private String school_id;
            private String teacher;

            public String getSchool_id() {
                return school_id;
            }

            public void setSchool_id(String school_id) {
                this.school_id = school_id;
            }

            public ChildsBean(Parcel in) {
                this._id = in.readString();
                this.firstName = in.readString();
                this.lastName = in.readString();
                this.verificationCard = in.readString();
                this.gender = in.readString();
                this.birthDate = in.readString();
                this.school = in.readString();
                this.teacher = in.readString();
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
            }
        }
    }
}
