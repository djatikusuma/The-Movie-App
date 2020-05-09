package com.codekinian.themovieapps

import android.app.Application
import com.codekinian.themovieapps.di.appModule
import com.codekinian.themovieapps.di.databaseModule
import com.codekinian.themovieapps.di.networkModule
import com.codekinian.themovieapps.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            // Android Context
            androidContext(this@BaseApplication)
            // modules
            modules(listOf(appModule, repositoryModule, networkModule, databaseModule))
        }
    }
}