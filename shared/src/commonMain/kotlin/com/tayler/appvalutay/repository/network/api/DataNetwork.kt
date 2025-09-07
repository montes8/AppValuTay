package com.tayler.appvalutay.repository.network.api

import com.tayler.appvalutay.model.LocationModel
import com.tayler.appvalutay.repository.network.KmmService
import com.tayler.appvalutay.repository.network.data.LocationResponse
import com.tayler.appvalutay.usecases.network.IDataNetwork


class DataNetwork : IDataNetwork {

    private val apiService: KmmService = KmmService()

    override suspend fun loadLocation() : String {
        return apiService.getLocation()
    }
}