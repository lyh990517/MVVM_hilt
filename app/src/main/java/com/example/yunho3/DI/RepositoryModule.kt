package com.example.yunho3.DI

import com.example.yunho3.DataSource.LocalDB.Dao
import com.example.yunho3.DataSource.Repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        Dao : Dao,
        IODispatcher : CoroutineDispatcher
    ) : RepositoryImpl{
        return RepositoryImpl(Dao, IODispatcher)
    }
}