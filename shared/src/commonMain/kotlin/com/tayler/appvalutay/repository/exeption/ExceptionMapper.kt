package com.tayler.appvalutay.repository.exeption

import kotlinx.serialization.Serializable

data class ExceptionMapper(
    val code : Int = 0,
    val content : String = "Errro genrrico"
): Exception()


class ErrorAuthorization: Exception()

class ErrorServer: Exception()

class ErrorGeneric: Exception()