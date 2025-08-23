package com.tayler.appvalutay

import androidx.lifecycle.ViewModel
import com.tayler.appvalutay.casesuses.UserCaseUse
import com.tayler.appvalutay.casesuses.network.IUserRepository
import kotlinx.coroutines.flow.MutableStateFlow

class AppViewModel(private val repository: UserCaseUse) : ViewModel() {

     val text = MutableStateFlow("")
    fun sayHello(name : String){
        val foundUser = repository.sayHello(name)
        text.value = foundUser?.let { "Hello '$it'" } ?: "User '$name' not found!"
    }
}