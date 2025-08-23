package com.tayler.appvalutay

import android.util.Log
import androidx.lifecycle.ViewModel
import com.tayler.appvalutay.usecases.AppCaseUse
import com.tayler.appvalutay.usecases.UserCaseUse
import kotlinx.coroutines.flow.MutableStateFlow

class AppViewModel(private val userCaseUse: UserCaseUse,
                   private val appCaseUse: AppCaseUse
) : ViewModel() {

     val text = MutableStateFlow("")
    fun sayHello(name : String){
        appCaseUse.saveSession("token")
        val foundUser = userCaseUse.sayHello(name)
        Log.d("tahprefe","${appCaseUse.getSession()}")
        text.value = foundUser.let { "Hello '$it'" }
    }
}