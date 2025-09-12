package com.tayler.appvalutay.repository.network.api

import com.tayler.appvalutay.model.LocationModel
import com.tayler.appvalutay.repository.network.KmmService
import com.tayler.appvalutay.repository.network.response.LocationRequest
import com.tayler.appvalutay.repository.network.response.LocationRequest.Companion.toLocations
import com.tayler.appvalutay.repository.network.response.LocationResponse
import com.tayler.appvalutay.repository.network.response.LocationResponse.Companion.loadToLocations
import com.tayler.appvalutay.usecases.network.IDataNetwork
import com.tayler.appvalutay.utils.parseJsonTo
import com.tayler.appvalutay.utils.parseListLocation

class DataNetwork : IDataNetwork {

    private val apiService: KmmService = KmmService()

    override suspend fun loadLocation() : List<LocationModel> {
        return apiService.getLocation().parseListLocation().loadToLocations()
    }

    override suspend fun saveLocation(): LocationModel {
        val response =  apiService.postLocation(
            LocationRequest("8888888","8888888"))
        return response.parseJsonTo<LocationResponse>().toLocations()
    }
}