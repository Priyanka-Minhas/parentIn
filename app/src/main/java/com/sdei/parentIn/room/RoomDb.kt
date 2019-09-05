package com.sdei.parentIn.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sdei.parentIn.model.ChildModel
import com.sdei.parentIn.model.ClassModel
import com.sdei.parentIn.model.SchoolModel


@Database(entities = [SchoolModel.DataBean::class,ChildModel.DataBean::class,ClassModel.DataBean::class], version = 1)
abstract class RoomDb : RoomDatabase() {
    abstract fun getDao(): DaoAccess

    companion object {
        private var instance: RoomDb? = null

        @Synchronized
        fun getInstance(context: Context): RoomDb {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDb::class.java, "familiasIn_database"
                ).allowMainThreadQueries().fallbackToDestructiveMigration()
                 .build()
            }
            return instance as RoomDb
        }
    }
}