package com.tayler.appvalutay.usecases

import com.tayler.appvalutay.model.UserModel
import com.tayler.appvalutay.usecases.db.IUserDataBase


class UserCaseUse(
    private val iUserDataBase: IUserDataBase
) {

    suspend fun saveUser():Boolean = iUserDataBase.insertUser(
        UserModel(0, "tayler", "123456", "qwkrnfvmndkcndcmndmcmdncm")
    )

    suspend fun getUser(): UserModel = iUserDataBase.getUser()?:UserModel()

}