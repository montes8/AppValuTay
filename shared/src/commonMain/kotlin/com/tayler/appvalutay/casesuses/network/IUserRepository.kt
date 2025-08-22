package com.tayler.appvalutay.casesuses.network

import com.tayler.appvalutay.model.User

interface IUserRepository {
    fun findUser(name : String): User?
    fun addUsers(users : List<User>)
}