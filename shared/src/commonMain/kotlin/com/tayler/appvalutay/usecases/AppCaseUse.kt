package com.tayler.appvalutay.usecases

import com.tayler.appvalutay.usecases.preferences.IAppPreferences

class AppCaseUse(
    private val preference: IAppPreferences
) {

    fun saveSession(value : String){
        preference.saveSession(value)
    }

    fun getSession() : Boolean{
        return preference.getSession()
    }
}