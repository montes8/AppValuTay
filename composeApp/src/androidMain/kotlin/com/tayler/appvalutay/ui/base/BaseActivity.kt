package com.tayler.appvalutay.ui.base

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.tayler.appvalutay.component.DialogGeneric
import com.tayler.appvalutay.component.ProgressDialogApp
import com.tayler.appvalutay.utils.mapperError

abstract class BaseActivity : ComponentActivity() {

    @Composable
    abstract fun SetScreenConfig()
    abstract  fun setDataGlobal()
    open fun getViewModel(): BaseViewModel? = null

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                if (getViewModel()?.uiStateBase?.loading == true){ ProgressDialogApp() }
                if (getViewModel()?.uiStateBase?.error == true){
                    DialogGeneric(getViewModel()?.uiStateBase?.errorType?.mapperError()?:"") {
                        getViewModel()?.uiStateBase = getViewModel()?.uiStateBase?.copy(error = false,
                            popUpGeneric = true, popUpGenericValue = it)?:BaseUiState()
                    }
                }
                SetScreenConfig()
        }
        setDataGlobal()
    }

}