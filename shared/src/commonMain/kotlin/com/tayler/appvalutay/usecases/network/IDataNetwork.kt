package com.tayler.appvalutay.usecases.network

import com.tayler.appvalutay.model.LocationModel

interface IDataNetwork {
    suspend fun loadLocation( ): String

}