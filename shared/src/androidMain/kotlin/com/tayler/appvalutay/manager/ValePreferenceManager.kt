package com.tayler.appvalutay.manager

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences


actual typealias ValePreferenceManager = Application

actual fun ValePreferenceManager.getInt(key: String ) : Int{
    val prefs: SharedPreferences = this.getSharedPreferences("shareValeSure", MODE_PRIVATE)
    return prefs.getInt(key, -1)
}

@SuppressLint("UseKtx")
actual fun ValePreferenceManager.setInt(key: String, value: Int) {
    val prefs: SharedPreferences = this.getSharedPreferences("shareValeSure", MODE_PRIVATE)
    val editor = prefs.edit()
    editor.putInt(key,value)
    editor.apply()
}

actual fun ValePreferenceManager.getString(key: String) : String{
    val prefs: SharedPreferences = this.getSharedPreferences("shareValeSure", MODE_PRIVATE)
    return prefs.getString(key, "")?:""
}

@SuppressLint("UseKtx")
actual fun ValePreferenceManager.setString(key: String, value: String) {
    val prefs: SharedPreferences = this.getSharedPreferences("shareValeSure", MODE_PRIVATE)
    val editor = prefs.edit()
    editor.putString(key,value)
    editor.apply()
}


actual fun ValePreferenceManager.getBoolean(key: String ) : Boolean{
    val prefs: SharedPreferences = this.getSharedPreferences("shareValeSure", MODE_PRIVATE)
    return prefs.getBoolean(key, false)
}


@SuppressLint("UseKtx")
actual fun ValePreferenceManager.setBoolean(key: String, value: Boolean) {
    val prefs: SharedPreferences = this.getSharedPreferences("shareValeSure", MODE_PRIVATE)
    val editor = prefs.edit()
    editor.putBoolean(key,value)
    editor.apply()
}
