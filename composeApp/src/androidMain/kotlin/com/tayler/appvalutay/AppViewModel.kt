package com.tayler.appvalutay

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tayler.appvalutay.repository.exeption.ExceptionMapper
import com.tayler.appvalutay.usecases.AppCaseUse
import com.tayler.appvalutay.usecases.DataUseCase
import com.tayler.appvalutay.usecases.UserCaseUse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class AppViewModel(private val userCaseUse: UserCaseUse,
                   private val appCaseUse: AppCaseUse,
                   private val dataUseCase: DataUseCase,
) : ViewModel() {

    init {
        getLocations()
    }
     val text = MutableStateFlow("")
    fun sayHello(name : String){
        appCaseUse.saveSession("token")
        val foundUser = userCaseUse.sayHello(name)
        Log.d("tahprefe","${appCaseUse.getSession()}")
        text.value = foundUser.let { "Hello '$it'" }
    }

    fun getLocations(){
        viewModelScope.launch(Dispatchers.IO){
            try {
                val response = dataUseCase.loadLocations()
                Log.d("TAGLOCATION",response.toString())
            }catch (ex:Throwable){
                ex.printStackTrace()
                 when (ex) {
                    is ExceptionMapper -> {
                        Log.d("TayError",ex.content)
                    }

                    else -> {
                        Log.d("TayError","errogenerico")
                    }
                }
            }
        }
    }
}