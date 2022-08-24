package com.example.yunho3.DI

import android.content.Context
import androidx.room.Room
import com.example.yunho3.DataSource.LocalDB.DataBase
import com.example.yunho3.DataSource.Repository.RepositoryImpl
import com.example.yunho3.DataSource.Repository.repository
import com.example.yunho3.Domain.DeleteOneUseCase
import com.example.yunho3.Domain.GetAllUseCase
import com.example.yunho3.Domain.InsertOneUseCase
import com.example.yunho3.Presentation.ViewModel.MainViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val appModule = module {

    single { Dispatchers.IO }
    single { Dispatchers.Main }

    single { getDB(androidApplication()) }
    single { getDao(get()) }

    single<repository> { RepositoryImpl(get(),get()) }

    factory { GetAllUseCase(get()) }
    factory { InsertOneUseCase(get()) }
    factory { DeleteOneUseCase(get()) }

    viewModel { MainViewModel(get()) }

}

internal fun getDB(context: Context) = Room.databaseBuilder(context,DataBase::class.java,DataBase.DB_NAME).build()

internal fun getDao(dataBase: DataBase) = dataBase.Dao()