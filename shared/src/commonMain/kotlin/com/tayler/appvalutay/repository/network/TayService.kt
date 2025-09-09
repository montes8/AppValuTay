package com.tayler.appvalutay.repository.network

import com.tayler.appvalutay.repository.response.LocationRequest
import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.http.path
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

const val BASE_URL = "cockatoo-close-teal.ngrok-free.app/service"
class KmmService: KoinComponent {

    private val client: HttpClient by inject()

    inline fun <reified T>HttpRequestBuilder.pathUrlPost(path: String, body : T){
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
    suspend fun getLocation(): String{
        val response = client.get {
            pathUrlGet("config/location")
        }
        return response.bodyAsText()
    }

    suspend fun postLocation(body : LocationRequest): String{
        val response = client.post {
            pathUrlPost("config/location",body)
        }
        return response.bodyAsText()
    }
}