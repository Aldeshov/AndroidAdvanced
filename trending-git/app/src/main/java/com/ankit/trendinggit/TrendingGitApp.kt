package com.ankit.trendinggit

import android.app.Application
import com.ankit.trendinggit.model.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class TrendingGitApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this

        // Start Koin
        startKoin{
            androidLogger()
            androidContext(this@TrendingGitApp)
            modules(appModule)
        }
    }

    companion object {
        lateinit var instance: TrendingGitApp
    }
}