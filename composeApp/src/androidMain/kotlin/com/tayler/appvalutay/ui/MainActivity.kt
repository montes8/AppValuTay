package com.tayler.appvalutay.ui

import android.os.Handler
import androidx.compose.runtime.Composable
import com.tayler.appvalutay.ui.base.BaseActivity
import com.tayler.appvalutay.ui.base.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {
    private val viewModel : AppViewModel by viewModel()

    @Composable
    override fun SetScreenConfig() {
        App(viewModel)

    }

    override fun setDataGlobal() {
       // viewModel.saveUser()
        viewModel.getLocations()
    }

    override fun getViewModel(): BaseViewModel = viewModel
}