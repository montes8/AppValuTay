package com.tayler.appvalutay.usecases

import com.tay.taysecurity.repository.network.api.TayDataNetwork
import com.tay.taysecurity.usecases.repository.network.ITayDataNetwork

class DataUseCase  {

    private val iDataNetwork : IDataNetwork = TayDataNetwork()

    suspend fun loadLocations() = iDataNetwork.loadLocation()

}