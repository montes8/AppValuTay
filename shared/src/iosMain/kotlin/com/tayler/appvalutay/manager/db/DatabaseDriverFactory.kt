package com.tayler.appvalutay.manager.db

import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.tayler.appvalutay.database.AppValuTayDb

internal actual fun databaseDriverFactory(): AppValuTayDb {
    val driver = NativeSqliteDriver(AppValuTayDb.Schema, "appValuTayDb.db")
    return AppValuTayDb(driver)
}