package com.tayler.appvalutay.di

import com.tayler.appvalutay.casesuses.UserCaseUse
import com.tayler.appvalutay.casesuses.network.IUserRepository
import com.tayler.appvalutay.getPlatform
import com.tayler.appvalutay.repository.UserRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    singleOf(::UserRepository) { bind<IUserRepository>() }
    factoryOf(::UserCaseUse)
    factory { getPlatform(this) }
}