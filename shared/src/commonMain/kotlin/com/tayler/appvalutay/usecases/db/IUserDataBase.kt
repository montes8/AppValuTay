package com.tayler.appvalutay.usecases.db

import com.tayler.appvalutay.model.UserModel

interface IUserDataBase {
    suspend fun insertUser(user: UserModel) :Boolean
    suspend fun getUserById(id: Long): UserModel?

    suspend fun getUser(): UserModel?
    suspend fun getLogin(name: String,pass : String): UserModel?
    suspend fun getAllUsers(): List<UserModel>
    suspend fun deleteUserById(id: Long)

}