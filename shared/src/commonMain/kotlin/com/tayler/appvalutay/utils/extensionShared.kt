package com.tayler.appvalutay.utils

import com.tayler.appvalutay.repository.response.LocationResponse
import kotlinx.serialization.json.Json

inline fun <reified T>parseJsonToList(json : String): T {
    return Json.decodeFromString<T>(json)
}

fun String.parseListLocation(): List<LocationResponse> {
    return Json.decodeFromString<List<LocationResponse>>(this)
}