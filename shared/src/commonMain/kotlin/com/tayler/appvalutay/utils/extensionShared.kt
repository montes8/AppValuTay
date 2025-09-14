package com.tayler.appvalutay.utils

import com.tayler.appvalutay.repository.network.response.LocationResponse
import kotlinx.serialization.json.Json.Default.decodeFromString

internal inline fun <reified R : Any> String.parseJsonTo() =
    decodeFromString<R>(this)

fun String.parseListLocation(): List<LocationResponse> {
    return decodeFromString<List<LocationResponse>>(this)
}


