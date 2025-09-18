package com.tayler.appvalutay.repository.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM UserEntity")
    suspend fun getUser(): UserEntity

    @Query("SELECT * FROM UserEntity where id = :id")
    suspend fun getUseByIdr(id:Long): UserEntity

    @Query("SELECT * FROM UserEntity")
    suspend fun getAllUser(): List<UserEntity>

    @Insert
    suspend fun insert(model: UserEntity)

    @Query("DELETE FROM UserEntity")
    suspend fun delete()
}