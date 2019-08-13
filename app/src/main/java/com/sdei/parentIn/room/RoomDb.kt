package com.sdei.parentIn.room

//
//@Database(entities = [], version = 1)
//abstract class RoomDb : RoomDatabase() {
//    abstract fun noteDao(): DaoAccess
//
//    companion object {
//
//        private var instance: RoomDb? = null
//
//        @Synchronized
//        fun getInstance(context: Context): RoomDb {
//            if (instance == null) {
//                instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    RoomDb::class.java, "app_database"
//                ).fallbackToDestructiveMigration()
//                 .build()
//            }
//            return instance as RoomDb
//        }
//    }
//}