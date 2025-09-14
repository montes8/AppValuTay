package com.tayler.appvalutay.manager.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.tayler.appvalutay.database.AppValuTayDb
lateinit var appContext: Context


@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class DatabaseDriverFactory {

    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = AppValuTayDb.Schema,
            context = appContext,
            name = "appValuTayDb.db"
        )
    }
}