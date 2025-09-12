package com.tayler.appvalutay.manager.db

import android.content.Context
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.tayler.appvalutay.database.AppValuTayDb

lateinit var appContext: Context

internal actual fun databaseDriverFactory(): AppValuTayDb {
    val driver = AndroidSqliteDriver(AppValuTayDb.Schema, appContext, "appValuTayDb.db")
    return AppValuTayDb(driver)
}