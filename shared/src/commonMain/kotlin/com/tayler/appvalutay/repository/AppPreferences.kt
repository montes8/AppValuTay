package com.tayler.appvalutay.repository

import com.tayler.appvalutay.manager.ValePreferenceManager
import com.tayler.appvalutay.manager.getString
import com.tayler.appvalutay.manager.setString
import com.tayler.appvalutay.usecases.preferences.IAppPreferences

class AppPreferences(private val preference: ValePreferenceManager) : IAppPreferences {

    override fun saveSession(value: String) {
        preference.setString("PREFERENCES_TOKEN",value)
    }

    override fun getSession(): Boolean {
       return  preference.getString("PREFERENCES_TOKEN").isNotEmpty()
    }
}