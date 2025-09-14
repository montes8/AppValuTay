@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package com.tayler.appvalutay.manager

import platform.Foundation.NSUserDefaults
import platform.darwin.NSObject


actual typealias ValePreferenceManager = NSObject

actual fun ValePreferenceManager.getInt(key: String) : Int {
    return NSUserDefaults.standardUserDefaults.integerForKey(key).toInt()
}

actual fun ValePreferenceManager.setInt(key: String, value : Int){
    NSUserDefaults.standardUserDefaults.setInteger(value.toLong(),key)
}

actual fun ValePreferenceManager.getString(key: String) : String {
    return NSUserDefaults.standardUserDefaults.stringForKey(key)?:""
}

actual fun ValePreferenceManager.setString(key: String, value : String){
    NSUserDefaults.standardUserDefaults.setObject(value,key)
}

actual fun ValePreferenceManager.getBoolean(key: String) : Boolean {
    return NSUserDefaults.standardUserDefaults.boolForKey(key)
}

actual fun ValePreferenceManager.setBoolean(key: String, value : Boolean){
    NSUserDefaults.standardUserDefaults.setBool(value,key)
}