package com.tayler.appvalutay.ui

import android.app.Application
import com.tayler.appvalutay.ui.base.BaseViewModel
import com.tayler.appvalutay.usecases.DataUseCase
import com.tayler.appvalutay.usecases.UserCaseUse

class AppViewModel(private val dataUseCase: DataUseCase,
                   application: Application
) : BaseViewModel(application) {

    fun getLocations(){
        execute {
            dataUseCase.loadLocations()
        }
    }

}