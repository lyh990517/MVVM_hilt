package com.example.yunho3.Presentation.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.yunho3.DataSource.Entity.DataEntity
import com.example.yunho3.DataSource.Repository.RepositoryImpl
import com.example.yunho3.Domain.DeleteOneUseCase
import com.example.yunho3.Domain.GetAllUseCase
import com.example.yunho3.Domain.InsertOneUseCase
import com.example.yunho3.Presentation.BaseFile.BaseViewModel
import com.example.yunho3.Presentation.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class MainViewModel
@Inject
constructor(
    private val repositoryImpl: RepositoryImpl
) : BaseViewModel() {
    private val _LiveData = MutableLiveData<DataState>(DataState.Uninitialized)
    val LiveData = _LiveData
    override fun fetchData(): Job = viewModelScope.launch {
        _LiveData.postValue(DataState.Loading)
        _LiveData.postValue(DataState.Success(repositoryImpl.getAll()))
    }

    fun insertOne(entity: DataEntity) = viewModelScope.launch {
        _LiveData.postValue(DataState.Loading)
        repositoryImpl.insertOne(entity)
        _LiveData.postValue(DataState.Success(repositoryImpl.getAll()))
    }

    fun deleteOne(id: Long) = viewModelScope.launch {
        _LiveData.postValue(DataState.Loading)
        repositoryImpl.deleteOne(id)
        _LiveData.postValue(DataState.Delete)
    }
}