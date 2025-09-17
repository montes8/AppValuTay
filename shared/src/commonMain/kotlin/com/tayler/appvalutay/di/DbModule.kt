package com.tayler.appvalutay.di

import com.tayler.appvalutay.manager.db.AppDatabase
import com.tayler.appvalutay.repository.db.UserDao
import org.koin.core.module.Module
import org.koin.dsl.module

fun dbModule(): Module = module {
    single<UserDao> { get<AppDatabase>().getUserDao() }
}