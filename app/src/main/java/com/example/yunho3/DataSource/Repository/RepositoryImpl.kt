package com.example.yunho3.DataSource.Repository

import com.example.yunho3.DataSource.Entity.DataEntity
import com.example.yunho3.DataSource.LocalDB.Dao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class RepositoryImpl(
    private val Dao : Dao,
    private val IODispatcher: CoroutineDispatcher
) : repository{
    override suspend fun getAll(): List<DataEntity> = withContext(IODispatcher){
        Dao.getAll()
    }

    override suspend fun deleteOne(id: Long) = withContext(IODispatcher){
        Dao.deleteOne(id)
    }

    override suspend fun insertOne(entity: DataEntity) = withContext(IODispatcher){
        Dao.insertOne(entity)
    }
}