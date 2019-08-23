package com.sdei.parentIn.interfaces;

import android.os.Parcel;
import android.os.Parcelable;

import com.sdei.parentIn.model.BaseModel;

import org.jetbrains.annotations.NotNull;

public class UserModel extends BaseModel implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    public UserModel(@NotNull String message) {
        super.setMessage(message);
    }

    /**
     * statusCode : 200
     * data : {"_id":"5d5cee72254b342ebe39f4d5","firstName":"Lucifer","lastName":"Morningstar","phoneNumber":"8699826276","relationWithChild":"Guardian","homeAddress":"Top Floor, Lux, Los Angeles","isSameAddressAsStudent":true,"levelOfEducation":"PHD","noOfStudents":1,"emailAddress":"abc@gmail.com","password":"123456789","roleId":3,"__v":0,"token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjZWxsX251bWJlciI6ImFiY0BnbWFpbC5jb20iLCJpYXQiOjE1NjYzNzE0ODksImV4cCI6MTU2NjQ1Nzg4OX0.ULjh2x390TXPdLcroY2JxugPe6So6mn6CUn3IcWUwYw"}
     * message : Exitoso
     */
    private DataBean data;

    public UserModel(Parcel in) {
        this.data = in.readParcelable(DataBean.class.getClassLoader());
    }


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
        dest.writeParcelable(this.data, flags);
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
        private String token;

        public DataBean(String _id, String firstName, String lastName, String phoneNumber, String relationWithChild, String homeAddress, boolean isSameAddressAsStudent, String levelOfEducation, int noOfStudents, String emailAddress, String password, int roleId, int __v, String token) {
            this._id = _id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.relationWithChild = relationWithChild;
            this.homeAddress = homeAddress;
            this.isSameAddressAsStudent = isSameAddressAsStudent;
            this.levelOfEducation = levelOfEducation;
            this.noOfStudents = noOfStudents;
            this.emailAddress = emailAddress;
            this.password = password;
            this.roleId = roleId;
            this.__v = __v;
            this.token = token;
        }

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
            this.token = in.readString();
            boolean[] temp = new boolean[1];
            in.readBooleanArray(temp);
            isSameAddressAsStudent = temp[0];
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

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
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
            dest.writeString(this.token);
            dest.writeBooleanArray(new boolean[]{isSameAddressAsStudent});
        }
    }
}
