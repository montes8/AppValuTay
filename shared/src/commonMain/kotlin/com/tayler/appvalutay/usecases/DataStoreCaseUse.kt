package com.tayler.appvalutay.usecases

import com.tayler.appvalutay.usecases.preferences.IDataStorePreferences

class DataStoreCaseUse(private val preferences: IDataStorePreferences
) {

    suspend fun saveSession(value : String){
        preferences.saveSession(value)
    }

    suspend fun getSession() : String{
        return preferences.getSession()
    }
}