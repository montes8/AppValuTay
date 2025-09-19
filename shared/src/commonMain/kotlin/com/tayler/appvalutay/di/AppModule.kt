package com.tayler.appvalutay.di

import com.tayler.appvalutay.usecases.UserCaseUse
import com.tayler.appvalutay.getPlatform
import com.tayler.appvalutay.repository.db.UserDataBase
import com.tayler.appvalutay.repository.preferences.AppPreferences
import com.tayler.appvalutay.repository.network.api.DataNetwork
import com.tayler.appvalutay.repository.preferences.DataStorePreference
import com.tayler.appvalutay.usecases.AppCaseUse
import com.tayler.appvalutay.usecases.DataStoreCaseUse
import com.tayler.appvalutay.usecases.DataUseCase
import com.tayler.appvalutay.usecases.db.IUserDataBase
import com.tayler.appvalutay.usecases.network.IDataNetwork
import com.tayler.appvalutay.usecases.preferences.IAppPreferences
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    singleOf(::AppPreferences) { bind<IAppPreferences>() }
    singleOf(::DataNetwork) { bind<IDataNetwork>() }
    singleOf(::UserDataBase) { bind<IUserDataBase>() }
    factoryOf(::AppCaseUse)
    factoryOf(::DataUseCase)
    factoryOf(::UserCaseUse)
    factory { getPlatform(this) }
}