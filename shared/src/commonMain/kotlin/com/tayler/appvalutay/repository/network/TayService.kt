package com.tayler.appvalutay.repository.network


import com.tayler.appvalutay.repository.network.manager.KtorApi
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class KmmService: KtorApi() {
    //val client = HttpClient()
  /*  suspend fun getLocation(): List<TayLocationResponse> = client.get{
        pathUrlGet("config/location")
    }.body()*/


    suspend fun getLocation(): String{
        var response = client.get {
            pathUrlGet("config/location")
        }
        return response.bodyAsText()
    }
}