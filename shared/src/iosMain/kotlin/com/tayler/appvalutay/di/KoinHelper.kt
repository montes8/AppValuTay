package com.tayler.appvalutay.di

import com.tayler.appvalutay.manager.db.platformModule
import com.tayler.appvalutay.model.LocationModel
import com.tayler.appvalutay.model.UserModel
import com.tayler.appvalutay.usecases.AppCaseUse
import com.tayler.appvalutay.usecases.DataUseCase
import com.tayler.appvalutay.usecases.UserCaseUse
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class KoinHelper : KoinComponent {
    private val appCaseUse : AppCaseUse by inject()
    private val userCaseUse : UserCaseUse by inject()
    private val dataUseCase : DataUseCase by inject()
    fun getSession() : Boolean = appCaseUse.getSession()

    suspend fun saveUser() : Boolean = userCaseUse.saveUser()
    suspend fun getUser() : UserModel = userCaseUse.getUser()
    suspend fun loadLocations() : List<LocationModel> = dataUseCase.loadLocations()
}

fun initKoinIos() = initKoin(appDeclaration = {
    modules(appModule,networkModule,dbModule(), platformModule())
})