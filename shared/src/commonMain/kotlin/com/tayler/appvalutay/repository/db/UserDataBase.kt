package com.tayler.appvalutay.repository.db

import com.tayler.appvalutay.model.UserModel
import com.tayler.appvalutay.usecases.db.IUserDataBase

class UserDataBase(private val userDao: UserDao): IUserDataBase {
    override suspend fun insertUser(user: UserModel): Boolean {
        userDao.insert(UserEntity(0,"tay","123456789","we5432432432343"))
        return true
    }

    override suspend fun getUser(): UserModel? {
       return userDao.getUser().toUser()
    }

}