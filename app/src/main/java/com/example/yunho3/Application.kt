package com.example.yunho3

import android.app.Application
import com.example.yunho3.DI.appModule
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

@HiltAndroidApp
class Application :Application(){
    override fun onCreate() {
        super.onCreate()
    }
}