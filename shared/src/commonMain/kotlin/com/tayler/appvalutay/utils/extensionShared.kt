package com.tayler.appvalutay.utils

import com.tayler.appvalutay.repository.response.LocationResponse
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.Json.Default.decodeFromString

/*inline fun <reified T> String.parseJsonTo(): T {
    return Json.decodeFromString<T>(this)
}*/

internal inline fun <reified R : Any> String.parseJsonTo() =
    decodeFromString<R>(this)

fun String.parseListLocation(): List<LocationResponse> {
    return decodeFromString<List<LocationResponse>>(this)
}


