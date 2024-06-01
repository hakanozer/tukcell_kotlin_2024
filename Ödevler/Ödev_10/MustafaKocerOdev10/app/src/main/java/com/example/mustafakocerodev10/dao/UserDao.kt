package com.example.mustafakocerodev10.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mustafakocerodev10.entity.User


@Dao
interface UserDao {

    @Insert
    fun insertUser(user: User): Long // sqlite bize id'sini döndürür

    @Query("SELECT * FROM users where userName = :userName")
    fun getOneUserByUsername(userName: String): User?

}