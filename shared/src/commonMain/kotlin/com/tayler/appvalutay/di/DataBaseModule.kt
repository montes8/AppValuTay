package com.tayler.appvalutay.di

import com.tayler.appvalutay.manager.db.DatabaseDriverFactory
import org.koin.dsl.module

val dbModule = module {
    single {
        DatabaseDriverFactory()
    }
}