package com.tayler.appvalutay.repository.network.api

import com.tayler.appvalutay.model.LocationModel
import com.tayler.appvalutay.repository.network.KmmService
import com.tayler.appvalutay.repository.response.LocationResponse
import com.tayler.appvalutay.repository.response.LocationResponse.Companion.loadToLocations
import com.tayler.appvalutay.usecases.network.IDataNetwork
import com.tayler.appvalutay.utils.parseListLocation

class DataNetwork : IDataNetwork {

    private val apiService: KmmService = KmmService()

    override suspend fun loadLocation() : List<LocationModel> {
        return apiService.getLocation().parseListLocation().loadToLocations()
    }
}