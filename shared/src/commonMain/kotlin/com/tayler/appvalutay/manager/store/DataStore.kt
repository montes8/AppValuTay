package com.tayler.appvalutay.manager.store

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import org.koin.core.module.Module


expect fun createDataStoreBasic(): DataStore<Preferences>

internal const val dataStoreFileName = "storeAppTay"


expect fun platformModuleDataStore(): Module