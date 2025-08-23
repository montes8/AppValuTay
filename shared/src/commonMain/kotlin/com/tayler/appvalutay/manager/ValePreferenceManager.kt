package com.tayler.appvalutay.manager



expect class ValePreferenceManager

expect fun ValePreferenceManager.getInt(key: String) : Int
expect fun ValePreferenceManager.setInt(key: String, value: Int)
expect fun ValePreferenceManager.getString(key: String) : String
expect fun ValePreferenceManager.setString(key: String, value: String)
expect fun ValePreferenceManager.getBoolean(key: String) : Boolean
expect fun ValePreferenceManager.setBoolean(key: String, value: Boolean)