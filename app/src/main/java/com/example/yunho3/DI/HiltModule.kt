package com.example.yunho3.DI

import android.content.Context
import com.example.yunho3.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModule{

    @Singleton
    @Provides
    fun provideApp(@ApplicationContext app: Context) : Application {
        return app as Application
    }
}

