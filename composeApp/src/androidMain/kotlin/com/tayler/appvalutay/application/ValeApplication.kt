package com.tayler.appvalutay.application

import android.app.Application
import com.tayler.appvalutay.di.appModule
import com.tayler.appvalutay.di.initKoin
import com.tayler.appvalutay.di.viewModelModule
import com.tayler.appvalutay.manager.db.appContext
import com.tayler.appvalutay.model.DefaultData
import com.tayler.appvalutay.usecases.network.IUserRepository
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class ValeApplication: Application()  {

    private val userRepository : IUserRepository by inject()

    override fun onCreate() {
        super.onCreate()
        appContext = this
        initKoin {
            androidContext(this@ValeApplication)
            androidLogger()
            modules( viewModelModule)
        }
        userRepository.addUsers(DefaultData.DEFAULT_USERS)

    }
}