package com.tayler.appvalutay.di

import com.tayler.appvalutay.repository.exeption.ApiException
import com.tayler.appvalutay.repository.exeption.ErrorAuthorization
import com.tayler.appvalutay.repository.exeption.ErrorGeneric
import com.tayler.appvalutay.repository.exeption.ExceptionMapper
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
private val networkModule = module {
    single {
       HttpClient {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        useAlternativeNames = false
                        serializersModule = SerializersModule {
                            contextual(Instant::class, InstantSerializer)
                        }
                    },
                )
            }

           HttpResponseValidator {
               validateResponse { response ->
                   if (response.status != HttpStatusCode.OK) {
                       val statusCode = response.status.value
                       val error =  response.bodyAsText()
                       when (statusCode) {
                           in 300..399 -> throw ErrorGeneric()
                           in 400..499 ->{
                               if (statusCode == 401){
                                   throw ErrorAuthorization()
                               }else{
                                   throw ExceptionMapper(response.status.value, error.parseJsonTo<ApiException>())
                               }
                           }
                           in 500..599 ->  throw ExceptionMapper(response.status.value, error.parseJsonTo<ApiException>())
                       }
                   }
               }
           }

            install(Logging) {
                logger = requestLogger
                level = LogLevel.ALL
            }

            install(HttpTimeout) {
                socketTimeoutMillis = 60_000
                requestTimeoutMillis = 60_000
            }
        }
    }
}
