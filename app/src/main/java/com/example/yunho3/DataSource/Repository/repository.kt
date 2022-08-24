package com.example.yunho3.DataSource.Repository

import com.example.yunho3.DataSource.Entity.DataEntity

interface repository {

    suspend fun getAll():List<DataEntity>

    suspend fun deleteOne(id:Long)

    suspend fun insertOne(entity: DataEntity)
}