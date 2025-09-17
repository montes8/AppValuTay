package com.tayler.appvalutay.repository.db

import com.tayler.appvalutay.model.UserModel
import com.tayler.appvalutay.usecases.db.IUserDataBase

class UserDataBase: IUserDataBase {
    override suspend fun insertUser(user: UserModel): Boolean {
        return true
    }

    override suspend fun getUser(): UserModel? {
       return UserModel()
    }

}