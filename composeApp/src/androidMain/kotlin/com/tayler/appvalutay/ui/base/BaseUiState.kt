package com.tayler.appvalutay.ui.base

data class BaseUiState(
    var popUpGeneric: Boolean = false,
    var loading: Boolean = false,
    var error: Boolean = false,
    var errorType: Throwable = Throwable()
)