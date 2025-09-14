package com.tayler.appvalutay.usecases

import com.tayler.appvalutay.Platform
import com.tayler.appvalutay.model.UserModel
import com.tayler.appvalutay.usecases.db.IUserDataBase
import com.tayler.appvalutay.usecases.network.IUserRepository
import kotlin.let


class UserCaseUse(
    private val repository: IUserRepository,
    private val iUserDataBase: IUserDataBase,
    private val platform: Platform
) {

    fun sayHello(name : String) : String{
        val foundUser = repository.findUser(name)
        return foundUser?.let { "Hello '$it' from ${platform.name}" } ?: "User '$name' not found!"
    }

    suspend fun saveUser():Boolean = iUserDataBase.insertUser(
        UserModel(0, "tayler", "123456", "qwkrnfvmndkcndcmndmcmdncm")
    )

    suspend fun getUser(): UserModel = iUserDataBase.getUser()?:UserModel()

}