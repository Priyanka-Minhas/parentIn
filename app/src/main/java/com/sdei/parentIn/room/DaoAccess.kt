package com.sdei.parentIn.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
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
//
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSingleSchoolRecord(act: SchoolModel.DataBean)

    @Query("SELECT * FROM SchoolDataBean")
    fun fetchSchoolList(): List<SchoolModel.DataBean>
//
//    @Insert
//    fun insertSchoolList(friends: ArrayList<SchoolModel.DataBean>)
}
