package com.tayler.appvalutay.repository.response

import com.tayler.appvalutay.model.LocationModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocationResponse(
    @SerialName("id")
    var id : String?,
    @SerialName("latitude")
    var latitude : String?,
    @SerialName("longitude")
    var longitude : String?
){
    companion object{
        fun loadToLocations(response : List<LocationResponse>) = response.map {
            LocationModel(
                id = it.id ?: "",
                latitude = it.latitude ?: "0.0",
                longitude = it.longitude ?: "0.0"
            )
        }
    }
}