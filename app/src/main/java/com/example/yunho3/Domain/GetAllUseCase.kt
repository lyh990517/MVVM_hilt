package com.example.yunho3.Domain

import com.example.yunho3.DataSource.Entity.DataEntity
import com.example.yunho3.DataSource.Repository.repository

internal class GetAllUseCase(
    private val repository: repository
) {
    suspend operator fun invoke(): List<DataEntity>{
        return repository.getAll()
    }
}