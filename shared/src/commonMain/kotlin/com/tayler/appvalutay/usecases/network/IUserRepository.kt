package com.tayler.appvalutay.usecases.network

import com.tayler.appvalutay.model.UserModel

interface IUserRepository {
    fun findUser(name : String): UserModel?
    fun addUsers(users : List<UserModel>)
}