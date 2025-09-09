package com.tayler.appvalutay

import android.content.Context
import android.os.Build
import org.koin.core.scope.Scope
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.Logger

class AndroidPlatform(context: Context) : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT} - context:$context"
}

actual fun getPlatform(scope: Scope): Platform = AndroidPlatform(scope.get())

actual val requestLogger: Logger
    get() = Logger.ANDROID