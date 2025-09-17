package com.tayler.appvalutay.manager.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<AppDatabase> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath("appValeTay.db")

    return Room.databaseBuilder<AppDatabase>(
        context = appContext,
        name = dbFile.absolutePath,
    )
}

actual fun platformModule(): Module = module {
    single<AppDatabase> {
        val builder = getDatabaseBuilder(context = get())
        getAppDatabase(builder)
    }
}