package com.example.yunho3.Domain

import com.example.yunho3.DataSource.Entity.DataEntity
import com.example.yunho3.DataSource.Repository.repository

internal class DeleteOneUseCase (
    private val repository: repository
) {
    suspend operator fun invoke(id: Long) {
        repository.deleteOne(id)
    }
}