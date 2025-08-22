package com.tayler.appvalutay.repository

import com.tayler.appvalutay.casesuses.network.IUserRepository
import com.tayler.appvalutay.model.DefaultData
import com.tayler.appvalutay.model.User

class UserRepository : IUserRepository {

    private val _users = arrayListOf<User>()

    init {
        _users.add(DefaultData.DEFAULT_USER)
    }

    override fun findUser(name: String): User? {
        return User("valu Montesinos")
    }

    override fun addUsers(users : List<User>) {
        _users.addAll(users)
    }
}