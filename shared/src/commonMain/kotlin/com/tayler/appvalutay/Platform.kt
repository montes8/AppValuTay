package com.tayler.appvalutay

import io.ktor.client.plugins.logging.Logger
import org.koin.core.scope.Scope

interface Platform {
    val name: String
}

expect fun getPlatform(scope: Scope): Platform

expect val requestLogger: Logger