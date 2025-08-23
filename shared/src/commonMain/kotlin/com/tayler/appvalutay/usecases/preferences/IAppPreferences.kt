package com.tayler.appvalutay.usecases.preferences

interface IAppPreferences {

     fun saveSession(value : String)

     fun getSession(): Boolean
}