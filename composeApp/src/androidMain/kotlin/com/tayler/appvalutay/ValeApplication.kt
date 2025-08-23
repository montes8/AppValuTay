package com.tayler.appvalutay

import android.app.Application
import com.tayler.appvalutay.usecases.network.IUserRepository
import com.tayler.appvalutay.di.appModule
import com.tayler.appvalutay.di.initKoin
import com.tayler.appvalutay.di.viewModelModule
import com.tayler.appvalutay.model.DefaultData.DEFAULT_USERS
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import kotlin.getValue

class ValeApplication: Application()  {

    private val userRepository : IUserRepository by inject()

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@ValeApplication)
            androidLogger()
            modules(appModule,viewModelModule)
        }

        userRepository.addUsers(DEFAULT_USERS)

    }
}