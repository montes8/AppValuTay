package com.tayler.appvalutay.repository.network.manager


import io.ktor.client.*
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

const val BASE_URL = "cockatoo-close-teal.ngrok-free.app/service"
//https://cockatoo-close-teal.ngrok-free.app/service

abstract class KtorApi {
    val client =  HttpClient() {
        install(HttpTimeout) {
            requestTimeoutMillis = 60_000
        }
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
            })
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.HEADERS
            filter { request ->
                request.url.host.contains(BASE_URL)
            }
            sanitizeHeader { header -> header == HttpHeaders.Authorization }
        }
    }
    fun HttpRequestBuilder.pathUrlGet(urlSecond: String){
        url {
            protocol = URLProtocol.HTTPS
            host = BASE_URL
            path(urlSecond)
           // parameters.append("token", "abc123")
            //headers { append(HttpHeaders.Authorization, "abc123")}
            contentType(ContentType.Application.Json)
        }
    }

    public inline fun <reified T>HttpRequestBuilder.pathUrlPost(path: String, body : T){
        url {
            protocol = URLProtocol.HTTPS
            host = BASE_URL
            path(path)
            // parameters.append("token", "abc123")
            //headers { append(HttpHeaders.Authorization, "abc123")}
            contentType(ContentType.Application.Json)//tipo de dato
            setBody(body) //metodos post body
        }
    }
}