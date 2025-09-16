package com.tayler.appvalutay.application

import android.app.Application
import com.tayler.appvalutay.di.appModule
import com.tayler.appvalutay.di.dbModule
import com.tayler.appvalutay.di.networkModule
import com.tayler.appvalutay.di.viewModelModule
import com.tayler.appvalutay.manager.db.appContext
import com.tayler.appvalutay.model.DefaultData
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ValeApplication: Application()  {

    override fun onCreate() {
        super.onCreate()
        appContext = this
        startKoin {
            androidContext(this@ValeApplication)
            androidLogger()
            modules(viewModelModule, appModule, networkModule, dbModule)
        }
    }
}