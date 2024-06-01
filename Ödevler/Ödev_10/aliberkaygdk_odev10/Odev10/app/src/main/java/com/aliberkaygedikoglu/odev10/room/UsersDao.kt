package com.aliberkaygedikoglu.odev10.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.aliberkaygedikoglu.odev10.entity.User

@Dao
interface UsersDao {
    @Insert
    fun insert(user: User): Long

    @Query("SELECT * FROM users WHERE username = :username AND password = :password")
    fun getUser(username: String, password: String): User
}