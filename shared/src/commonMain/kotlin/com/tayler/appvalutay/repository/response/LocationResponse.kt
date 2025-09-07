package com.tayler.appvalutay.repository.response

import com.tayler.appvalutay.model.LocationModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocationResponse(
    val uid : String?,
    val latitude : String?,
    val longitude : String?
){
    companion object{
        fun List<LocationResponse>.loadToLocations() = this.map {
            LocationModel(
                id = it.uid ?: "",
                latitude = it.latitude ?: "0.0",
                longitude = it.longitude ?: "0.0"
            )
        }
    }
}