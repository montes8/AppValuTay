package com.tayler.appvalutay.repository.exeption

import kotlinx.serialization.Serializable

data class ExceptionMapper(
    val code : Int = 0,
    val content : String = "Errro genrrico"
): Exception()

@Serializable
data class ErrorApp(var success: Boolean?)