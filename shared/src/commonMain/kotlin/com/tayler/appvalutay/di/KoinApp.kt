package com.tayler.appvalutay.di

import com.tayler.appvalutay.repository.network.exeption.ApiException
import com.tayler.appvalutay.repository.network.exeption.ErrorAuthorization
import com.tayler.appvalutay.repository.network.exeption.ErrorGeneric
import com.tayler.appvalutay.repository.network.exeption.ExceptionMapper
import com.tayler.appvalutay.repository.network.manager.InstantSerializer
import com.tayler.appvalutay.requestLogger
import com.tayler.appvalutay.utils.parseJsonTo
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import kotlinx.datetime.Instant
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.includes
import org.koin.dsl.module

fun initKoin(config : KoinAppDeclaration? = null){
    startKoin {
        includes(config)
        modules(appModule,networkModule)
    }
}

