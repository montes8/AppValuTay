package com.tayler.appvalutay.usecases

import com.tayler.appvalutay.repository.network.api.DataNetwork
import com.tayler.appvalutay.usecases.network.IDataNetwork


class DataUseCase  {

    private val iDataNetwork : IDataNetwork = DataNetwork()

    suspend fun loadLocations() = iDataNetwork.loadLocation()

    suspend fun saveLocations() = iDataNetwork.saveLocation()

}