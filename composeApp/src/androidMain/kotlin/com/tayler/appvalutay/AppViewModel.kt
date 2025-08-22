package com.tayler.appvalutay

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.tayler.appvalutay.casesuses.network.IUserRepository
import kotlinx.coroutines.flow.MutableStateFlow

class AppViewModel(private val repository: IUserRepository) : ViewModel() {

     val text = MutableStateFlow("")
    fun sayHello(name : String){
        val foundUser = repository.findUser(name)
        text.value = foundUser?.let { "Hello '$it'" } ?: "User '$name' not found!"
    }
}