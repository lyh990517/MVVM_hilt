package com.example.yunho3.Presentation

import com.example.yunho3.DataSource.Entity.DataEntity

sealed class DataState{

    object Uninitialized : DataState()

    object Loading : DataState()

    data class Success(
        val Data : List<DataEntity>
    ) : DataState()

    object Delete : DataState()

    object Error : DataState()
}
