package com.sdei.parentIn.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ChildModel extends BaseModel implements Parcelable {

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

    @Entity(tableName = "ChildDataBean", indices = {@Index(value = {"_id"},
            unique = true)})
    public static class DataBean implements Parcelable {
        /**
         * _id : 5d63b4558a53087261a09838
         * firstName : Demo
         * lastName : Student
         * verificationCard : 4598755
         * gender : M
         * birthDate : 11-10-1991
         * school : 5d5e322baaa88c670cb0babb
         * schoolName : Un Mundo Feliz
         * schoolAddress : Dr. Juan T. Edye 1029, esquina J. de Viana, Maldonado, maldonado, Uruguay
         * teacher : 5d5e35f6eacacc754b3dc7ba
         * teacherFirstName : Lucifer
         * teacherLastName : Morningstar
         * parent : 5d638261ec5a124176fc587e
         * parentFirstName : Lucifer
         * parentLastName : Morningstar
         */
        @PrimaryKey
        @NonNull
        private String _id;
        private String firstName;
        private String lastName;
        private String verificationCard;
        private String gender;
        private String birthDate;
        private String school;
        private String schoolName;
        private String schoolAddress;
        private String teacher;
        private String teacherFirstName;
        private String teacherLastName;
        private String parent;
        private String parentFirstName;
        private String parentLastName;
        private Boolean isSameAddressAsStudent;
        private String homeAddress;

        public Boolean getSameAddressAsStudent() {
            return isSameAddressAsStudent;
        }

        public void setSameAddressAsStudent(Boolean sameAddressAsStudent) {
            isSameAddressAsStudent = sameAddressAsStudent;
        }

        public String getHomeAddress() {
            return homeAddress;
        }

        public void setHomeAddress(String homeAddress) {
            this.homeAddress = homeAddress;
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

        public String getTeacher() {
            return teacher;
        }

        public void setTeacher(String teacher) {
            this.teacher = teacher;
        }

        public String getTeacherFirstName() {
            return teacherFirstName;
        }

        public void setTeacherFirstName(String teacherFirstName) {
            this.teacherFirstName = teacherFirstName;
        }

        public String getTeacherLastName() {
            return teacherLastName;
        }

        public void setTeacherLastName(String teacherLastName) {
            this.teacherLastName = teacherLastName;
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

        public DataBean() {
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
            dest.writeString(this.schoolName);
            dest.writeString(this.schoolAddress);
            dest.writeString(this.teacher);
            dest.writeString(this.teacherFirstName);
            dest.writeString(this.teacherLastName);
            dest.writeString(this.parent);
            dest.writeString(this.parentFirstName);
            dest.writeString(this.parentLastName);
            dest.writeValue(this.isSameAddressAsStudent);
            dest.writeString(this.homeAddress);
        }

        protected DataBean(Parcel in) {
            this._id = in.readString();
            this.firstName = in.readString();
            this.lastName = in.readString();
            this.verificationCard = in.readString();
            this.gender = in.readString();
            this.birthDate = in.readString();
            this.school = in.readString();
            this.schoolName = in.readString();
            this.schoolAddress = in.readString();
            this.teacher = in.readString();
            this.teacherFirstName = in.readString();
            this.teacherLastName = in.readString();
            this.parent = in.readString();
            this.parentFirstName = in.readString();
            this.parentLastName = in.readString();
            this.isSameAddressAsStudent = (Boolean) in.readValue(Boolean.class.getClassLoader());
            this.homeAddress = in.readString();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.data);
    }

    protected ChildModel(Parcel in) {
        this.data = in.createTypedArrayList(DataBean.CREATOR);
    }

    public static final Parcelable.Creator<ChildModel> CREATOR = new Parcelable.Creator<ChildModel>() {
        @Override
        public ChildModel createFromParcel(Parcel source) {
            return new ChildModel(source);
        }

        @Override
        public ChildModel[] newArray(int size) {
            return new ChildModel[size];
        }
    };


    public static class DataBeanRequest {


        /**
         * _id : 5d638261ec5a124176fc587e
         * child : {"_id":"5d63b4558a53087261a09838","firstName":"Demo","lastName":"Student","verificationCard":"4598755","gender":"M","birthDate":"11-10-1991","school":"5d5e322baaa88c670cb0babb","teacher":"5d5e35f6eacacc754b3dc7ba"}
         */

        private String _id;
        private ChildBean child;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public ChildBean getChild() {
            return child;
        }

        public void setChild(ChildBean child) {
            this.child = child;
        }

        public static class ChildBean implements Parcelable {
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

            public Boolean getSameAddressAsStudent() {
                return isSameAddressAsStudent;
            }

            public void setSameAddressAsStudent(Boolean sameAddressAsStudent) {
                isSameAddressAsStudent = sameAddressAsStudent;
            }

            public String getHomeAddress() {
                return homeAddress;
            }

            public void setHomeAddress(String homeAddress) {
                this.homeAddress = homeAddress;
            }

            private String teacher;
            private Boolean isSameAddressAsStudent;
            private String homeAddress;

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
                dest.writeValue(this.isSameAddressAsStudent);
                dest.writeString(this.homeAddress);
            }

            public ChildBean() {
            }

            protected ChildBean(Parcel in) {
                this._id = in.readString();
                this.firstName = in.readString();
                this.lastName = in.readString();
                this.verificationCard = in.readString();
                this.gender = in.readString();
                this.birthDate = in.readString();
                this.school = in.readString();
                this.teacher = in.readString();
                this.isSameAddressAsStudent = (Boolean) in.readValue(Boolean.class.getClassLoader());
                this.homeAddress = in.readString();
            }

            public static final Creator<ChildBean> CREATOR = new Creator<ChildBean>() {
                @Override
                public ChildBean createFromParcel(Parcel source) {
                    return new ChildBean(source);
                }

                @Override
                public ChildBean[] newArray(int size) {
                    return new ChildBean[size];
                }
            };
        }
    }

}
