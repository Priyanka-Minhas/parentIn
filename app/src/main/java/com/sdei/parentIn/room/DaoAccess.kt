package com.sdei.parentIn.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sdei.parentIn.model.ChildModel
import com.sdei.parentIn.model.ClassModel
import com.sdei.parentIn.model.SchoolModel

@Dao
interface DaoAccess {
//    @Query("Select * From user_model where _id =:id")
//    fun getUser(id: String): UserModel.DataBean
//
//    @Insert
//    fun insert(note: UserModel.DataBean)
//
//    @Update
//    fun update(note: UserModel.DataBean)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSingleSchoolRecord(model: SchoolModel.DataBean)

    @Query("SELECT * FROM SchoolDataBean")
    fun fetchSchoolList(): List<SchoolModel.DataBean>

    @Query("DELETE FROM SchoolDataBean")
    fun deleteSchoolDb()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSingleParentChild(model: ChildModel.DataBean)

    @Query("SELECT * FROM ChildDataBean")
    fun fetchParentChildList(): List<ChildModel.DataBean>

    @Query("DELETE FROM ChildDataBean")
    fun deleteParentChildDb()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSingleTeacherClass(model: ClassModel.DataBean)

    @Query("SELECT * FROM ClassDataBean")
    fun fetchTeacherClassList(): List<ClassModel.DataBean>

    @Query("DELETE FROM ClassDataBean")
    fun deleteTeacherClassDb()

//    @Insert
//    fun insertSchoolList(friends: ArrayList<SchoolModel.DataBean>)
}
