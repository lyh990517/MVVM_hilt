package com.example.yunho3.DI

import android.content.Context
import androidx.room.Room
import com.example.yunho3.DataSource.LocalDB.DataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Singleton
    @Provides
    fun getDB(@ApplicationContext
              context: Context) = Room.databaseBuilder(context, DataBase::class.java, DataBase.DB_NAME).build()

    @Singleton
    @Provides
    fun getDao(dataBase: DataBase) = dataBase.Dao()
}