package com.example.yunho3.Domain

import com.example.yunho3.DataSource.Entity.DataEntity
import com.example.yunho3.DataSource.Repository.repository

internal class InsertOneUseCase (
    private val repository: repository
) {
    suspend operator fun invoke(entity: DataEntity) {
        repository.insertOne(entity)
    }
}