package com.tayler.appvalutay.repository.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.tayler.appvalutay.usecases.preferences.IDataStorePreferences
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map


class DataStorePreference(private val dataStore :DataStore<Preferences>) : IDataStorePreferences{

    override suspend fun saveSession(value: String) {
  try {
      dataStore.edit { preferences ->
          preferences[stringPreferencesKey("PREFERENCES_TOKENStore")] = value
      }
  }catch (e: Exception){
      e.printStackTrace()
  }

    }

    override suspend fun getSession(): String {
       return dataStore.data.map { preferences ->
            val string = preferences[stringPreferencesKey("PREFERENCES_TOKENStore")] ?: ""
           string
        }.first()
    }
}