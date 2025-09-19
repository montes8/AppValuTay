package com.tayler.appvalutay.usecases.preferences

import com.tayler.appvalutay.manager.ValePreferenceManager
import com.tayler.appvalutay.manager.getString
import com.tayler.appvalutay.manager.setString

interface IDataStorePreferences{

    suspend fun saveSession(value : String)

    suspend fun getSession(): String
}