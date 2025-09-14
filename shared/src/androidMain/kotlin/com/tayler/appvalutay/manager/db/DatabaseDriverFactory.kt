package com.tayler.appvalutay.manager.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.tayler.appvalutay.database.AppValuTayDb
import org.koin.core.module.Module
import org.koin.dsl.module

lateinit var appContext: Context

/*
internal actual fun databaseDriverFactory(): AppValuTayDb {
    val driver = AndroidSqliteDriver(AppValuTayDb.Schema, appContext, "appValuTayDb.db")
    return AppValuTayDb(driver)
}
*/

actual class DatabaseDriverFactory {

    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = AppValuTayDb.Schema,
            context = appContext,
            name = "appValuTayDb.db"
        )
    }
}
