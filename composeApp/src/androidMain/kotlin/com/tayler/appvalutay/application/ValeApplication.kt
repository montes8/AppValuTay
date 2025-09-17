package com.tayler.appvalutay.application

import android.app.Application
import com.tayler.appvalutay.di.initKoin
import com.tayler.appvalutay.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class ValeApplication: Application()  {

    override fun onCreate() {
        super.onCreate()
        initKoin(appDeclaration = {
            androidContext(this@ValeApplication)
            androidLogger()
            modules(viewModelModule)

        })
    }
}