package com.tayler.appvalutay.usecases

import com.tayler.appvalutay.manager.store.createDataStoreBasic
import com.tayler.appvalutay.repository.preferences.DataStorePreference
import com.tayler.appvalutay.usecases.preferences.IDataStorePreferences

class DataStoreCaseUse(
) {

     var preferences : IDataStorePreferences = DataStorePreference(createDataStoreBasic())
    suspend fun saveSession(value : String){
        preferences.saveSession(value)
    }

    suspend fun getSession() : String{
        return preferences.getSession()
    }
}