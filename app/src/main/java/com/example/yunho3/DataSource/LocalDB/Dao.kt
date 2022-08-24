package com.example.yunho3.DataSource.LocalDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.yunho3.DataSource.Entity.DataEntity

@Dao
interface Dao {
    @Query("SELECT * FROM DataEntity")
    suspend fun getAll(): List<DataEntity>

    @Query("DELETE FROM DataEntity WHERE id = :id")
    suspend fun deleteOne(id: Long)

    @Insert
    suspend fun insertOne(entity: DataEntity)

}