package com.tayler.appvalutay.manager.store

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import io.ktor.http.ContentType

lateinit var myApplicationContext : Application



fun dataStore(context: Context): DataStore<Preferences> =
    createDataStore(
        producePath = { context.filesDir.resolve(dataStoreFileName).absolutePath }
    )


actual fun createDataStoreBasic(): DataStore<Preferences> {
    return PreferenceDataStoreFactory.create(
        produceFile = {
            myApplicationContext.preferencesDataStoreFile(dataStoreFileName)
        }
    )
}