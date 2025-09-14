package com.tayler.appvalutay.repository

import com.tayler.appvalutay.usecases.network.IUserRepository
import com.tayler.appvalutay.model.DefaultData
import com.tayler.appvalutay.model.UserModel

class UserRepository : IUserRepository {

    private val _users = arrayListOf<UserModel>()

    init {
        _users.add(DefaultData.DEFAULT_USER)
    }

    override fun findUser(name: String): UserModel? {
        return UserModel("valu Montesinos")
    }

    override fun addUsers(users : List<UserModel>) {
        _users.addAll(users)
    }
}