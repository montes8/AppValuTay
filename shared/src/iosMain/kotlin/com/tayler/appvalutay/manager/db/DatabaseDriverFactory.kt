package com.tayler.appvalutay.manager.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.tayler.appvalutay.database.AppValuTayDb


/*internal actual fun databaseDriverFactory(): AppValuTayDb {
    val driver = NativeSqliteDriver(AppValuTayDb.Schema, "appValuTayDb.db")
    return AppValuTayDb(driver)
}*/
actual class DatabaseDriverFactory {

    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(
            schema = AppValuTayDb.Schema,
            name = "appValuTayDb.db"
        )
    }
}