package com.tayler.appvalutay.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tayler.appvalutay.manager.db.AppDatabase

fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<AppDatabase> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath("appValeTay.db")

    return Room.databaseBuilder<AppDatabase>(
        context = appContext,
        name = dbFile.absolutePath,
    )
}