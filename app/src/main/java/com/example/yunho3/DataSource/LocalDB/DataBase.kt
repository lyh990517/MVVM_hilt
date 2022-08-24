package com.example.yunho3.DataSource.LocalDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.yunho3.DataSource.Entity.DataEntity

@Database(
    entities = [DataEntity::class],
    version = 1,
    exportSchema = false
)
abstract class DataBase : RoomDatabase(){
    abstract fun Dao() : Dao

    companion object{
        const val DB_NAME = "DataBase.db"
    }
}