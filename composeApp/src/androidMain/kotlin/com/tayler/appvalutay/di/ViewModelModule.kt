package com.tayler.appvalutay.di

import com.tayler.appvalutay.AppViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module



val viewModelModule = module {
    viewModel { AppViewModel(get()) }
}