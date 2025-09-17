package com.tayler.appvalutay.di

import com.tayler.appvalutay.ui.AppViewModel
import com.tayler.appvalutay.ui.base.BaseViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module



val viewModelModule = module {
    viewModel { AppViewModel(get(),get()) }
    viewModel { BaseViewModel(get()) }

}