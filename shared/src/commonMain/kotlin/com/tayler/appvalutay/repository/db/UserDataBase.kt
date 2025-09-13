package com.tayler.appvalutay.repository.db

import com.tayler.appvalutay.database.AppValuTayDb
import com.tayler.appvalutay.manager.db.DatabaseDriverFactory
import com.tayler.appvalutay.model.UserModel
import com.tayler.appvalutay.usecases.db.IUserDataBase
import database.UserEntity
import database.UserTableQueries

class UserDataBase(databaseDriverFactory: DatabaseDriverFactory):
    IUserDataBase {

    private val queries = AppValuTayDb(databaseDriverFactory.createDriver()).userTableQueries


    override suspend fun insertUser(user: UserModel) :Boolean{
        queries.insertUser(user.name, user.pass,user.token)
        return true
    }

    override suspend fun getUserById(id: Long): UserModel? {
        return queries
            .getUserById(id)
            .executeAsOneOrNull()
            ?.toUser()
    }

    override suspend fun getUser(): UserModel? {
        return queries
            .selectUser()
            .executeAsOneOrNull()
            ?.toUser()
    }

    override suspend fun getLogin(name: String, pass: String): UserModel? {
        return queries
            .getUserByActive(name,pass)
            .executeAsOneOrNull()
            ?.toUser()
    }

    override suspend fun getAllUsers(): List<UserModel> {
        return queries
            .selectAllUser()
            .executeAsList()
            .map { it.toUser() }
    }

    override suspend fun deleteUserById(id: Long) {
        queries.deleteNoteById(id)
    }
}

fun UserEntity.toUser(): UserModel {
    return UserModel(
        id = id,
        name = name,
        pass = pass,
        token = token
    )
}