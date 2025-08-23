package com.tayler.appvalutay.di

import com.tayler.appvalutay.usecases.UserCaseUse
import com.tayler.appvalutay.usecases.network.IUserRepository
import com.tayler.appvalutay.getPlatform
import com.tayler.appvalutay.repository.AppPreferences
import com.tayler.appvalutay.repository.UserRepository
import com.tayler.appvalutay.usecases.AppCaseUse
import com.tayler.appvalutay.usecases.preferences.IAppPreferences
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    singleOf(::UserRepository) { bind<IUserRepository>() }
    singleOf(::AppPreferences) { bind<IAppPreferences>() }
    factoryOf(::UserCaseUse)
    factoryOf(::AppCaseUse)
    factory { getPlatform(this) }
}