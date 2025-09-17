package com.tayler.appvalutay.usecases.db

import com.tayler.appvalutay.model.UserModel

interface IUserDataBase {
    suspend fun insertUser(user: UserModel) :Boolean

    suspend fun getUser(): UserModel?


}