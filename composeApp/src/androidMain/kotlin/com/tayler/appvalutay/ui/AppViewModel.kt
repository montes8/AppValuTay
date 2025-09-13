package com.tayler.appvalutay.ui

import android.app.Application
import com.tayler.appvalutay.ui.base.BaseViewModel
import com.tayler.appvalutay.usecases.AppCaseUse
import com.tayler.appvalutay.usecases.DataUseCase
import com.tayler.appvalutay.usecases.UserCaseUse
import kotlinx.coroutines.flow.MutableStateFlow

class AppViewModel(private val userCaseUse: UserCaseUse,
                   private val appCaseUse: AppCaseUse,
                   private val dataUseCase: DataUseCase,
                   application: Application
) : BaseViewModel(application) {

     val text = MutableStateFlow("")
    fun sayHello(name : String){
        appCaseUse.saveSession("token")
        val foundUser = userCaseUse.sayHello(name)
        text.value = foundUser.let { "Hello '$it'" }
    }

    fun getLocations(){
        execute {
            val response = dataUseCase.loadLocations()
        }
    }

    fun saveUser(){
        execute {
            val response = userCaseUse.saveUser()

        }
    }
}