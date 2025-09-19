package com.tayler.appvalutay.ui

import android.app.Application
import android.util.Log
import com.tayler.appvalutay.ui.base.BaseViewModel
import com.tayler.appvalutay.usecases.DataStoreCaseUse
import com.tayler.appvalutay.usecases.DataUseCase
import com.tayler.appvalutay.usecases.UserCaseUse
import com.tayler.appvalutay.utils.TAG_LOG

class AppViewModel(private val dataUseCase: DataUseCase,
                   private val userCaseUse: UserCaseUse,
                   private val dataStoreCaseUse: DataStoreCaseUse,
                   application: Application
) : BaseViewModel(application) {


    fun getLocations(){
        execute {
            dataUseCase.loadLocations()
        }
    }

    fun saveUser(){
        execute {
            userCaseUse.saveUser()
            var response = userCaseUse.getUser()
            Log.d(TAG_LOG,response.toString())
        }
    }

    fun saveStore(){
        execute {
            dataStoreCaseUse.saveSession("datastoreaytler")
            var response = dataStoreCaseUse.getSession()
            Log.d(TAG_LOG,response.toString())
        }
    }

}