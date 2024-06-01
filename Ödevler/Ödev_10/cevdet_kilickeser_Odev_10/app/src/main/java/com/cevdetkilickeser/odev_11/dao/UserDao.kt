package com.cevdetkilickeser.odev_11.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cevdetkilickeser.odev_11.entity.User

@Dao
interface UserDao {

    @Insert
    suspend fun signup(user: User): Long

    @Query("SELECT * FROM users WHERE email = :email AND password = :password LIMIT 1")
    suspend fun login(email: String, password: String): User?

    @Query("SELECT * FROM users WHERE email = :email LIMIT 1")
    suspend fun checkUser(email: String): User?

}