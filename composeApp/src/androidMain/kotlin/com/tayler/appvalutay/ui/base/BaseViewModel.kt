package com.tayler.appvalutay.ui.base

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tayler.appvalutay.repository.exeption.ErrorNetwork
import com.tayler.appvalutay.utils.mapperError
import com.tayler.appvalutay.utils.validNetWork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

open class BaseViewModel(private val application: Application): ViewModel() {

    var uiStateBase by mutableStateOf(BaseUiState())

    fun execute(loading: Boolean = true,func:suspend ()->Unit){
        if (application.validNetWork()){
            viewModelScope.launch(Dispatchers.IO){
                try {
                    uiStateBase = uiStateBase.copy(loading = loading)
                    delay(1000)
                    uiStateBase = uiStateBase.copy(loading = false)
                    func()
                }catch (ex:Exception){
                    uiStateBase = uiStateBase.copy(error = true, errorType = ex, loading = false)
                   var a = ex.mapperError()
                }
            }
        }else{
            uiStateBase = uiStateBase.copy(error = true, errorType = ErrorNetwork(), loading = false)
        }

    }

    fun executeAlter(loading: Boolean = true,func:suspend ()->Unit){
            viewModelScope.launch(Dispatchers.IO){
                try {
                    uiStateBase = uiStateBase.copy(loading = loading)
                    delay(1000)
                    uiStateBase = uiStateBase.copy(loading = false)
                    func()
                }catch (ex:Exception){
                    uiStateBase = uiStateBase.copy(error = true, errorType = ex, loading = false)
                }
            }
    }
}