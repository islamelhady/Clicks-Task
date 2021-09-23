package com.elhady.news

import android.app.Application
import com.elhady.news.di.networkModule
import com.elhady.news.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by islam elhady on 22-Sep-21.
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(networkModule)
            modules(repositoryModule)
        }

    }
}