package com.tayler.appvalutay.repository.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM UserEntity")
    fun getUser(): UserEntity

    @Query("SELECT * FROM UserEntity where id = :id")
    fun getUseByIdr(id:Long): Flow<UserEntity>

    @Query("SELECT * FROM UserEntity")
    fun getAllUser(): Flow<List<UserEntity>>

    @Insert
    suspend fun insert(model: UserEntity)

    @Query("DELETE FROM UserEntity")
    suspend fun delete()
}