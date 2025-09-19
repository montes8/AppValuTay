package com.tayler.appvalutay.di

import com.tayler.appvalutay.manager.db.platformModule
import com.tayler.appvalutay.manager.store.platformModuleDataStore
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(
            appModule,networkModule,dbModule(), platformModule(), platformModuleDataStore
        )
    }