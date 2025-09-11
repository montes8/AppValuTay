package com.tayler.appvalutay.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.provider.Settings
import com.tayler.appvalutay.repository.exeption.ErrorAuthorization
import com.tayler.appvalutay.repository.exeption.ErrorNetwork
import com.tayler.appvalutay.repository.exeption.ExceptionMapper


fun Context.isAirplaneModeActive(): Boolean {
    return Settings.Global.getInt(
            this.contentResolver, Settings.Global.AIRPLANE_MODE_ON, 0) != 0
}

fun Context.isConnected(): Boolean {
    val connectivityManager =
        this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    if (connectivityManager != null) {
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        return capabilities != null && capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
    }
    return false
}

fun Context.validNetWork() = isConnected() && !isAirplaneModeActive()

fun Throwable.mapperError(): String{
    return when (this) {
        is ExceptionMapper -> {
            this.apiException.errorMessage
        }

        is ErrorAuthorization -> {
            "Error de autenticacion"
        }

        is ErrorNetwork -> {
            "Error de conexion de internet"
        }

        else -> "Error  Generic"
    }
}