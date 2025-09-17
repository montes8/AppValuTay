package com.tayler.appvalutay.di

import com.tayler.appvalutay.usecases.AppCaseUse
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

class KoinHelper : KoinComponent {
    private val appCaseUse : AppCaseUse by inject()
    fun getSession() : Boolean = appCaseUse.getSession()
}

fun initKoinIos() = initKoin(appDeclaration = {
    modules(appModule,networkModule)

})