package com.tayler.appvalutay.manager.db

import app.cash.sqldelight.db.SqlDriver
import org.koin.core.module.Module

/*
internal expect fun databaseDriverFactory(): Module
*/

expect class DatabaseDriverFactory() {

    fun createDriver(): SqlDriver
}