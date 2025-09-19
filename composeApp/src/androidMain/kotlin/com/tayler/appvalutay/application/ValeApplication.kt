package com.tayler.appvalutay.application

import android.app.Application
import com.tayler.appvalutay.di.initKoin
import com.tayler.appvalutay.di.viewModelModule
import com.tayler.appvalutay.manager.store.myApplicationContext
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class ValeApplication: Application()  {

    override fun onCreate() {
        super.onCreate()
        myApplicationContext = this
        initKoin(appDeclaration = {
            androidContext(this@ValeApplication)
            androidLogger()
            modules(viewModelModule)

        })
    }
}