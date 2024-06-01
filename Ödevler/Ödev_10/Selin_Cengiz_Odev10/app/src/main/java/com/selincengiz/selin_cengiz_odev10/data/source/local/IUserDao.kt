package com.selincengiz.selin_cengiz_odev10.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.selincengiz.selin_cengiz_odev10.data.entities.UserRoom

@Dao
interface IUserDao {
    @Insert
    suspend fun insertUser(user: UserRoom)

    @Query("SELECT COUNT(*) FROM users WHERE email= :email and password = :password")
    suspend fun isUserExist(email: String, password: String): Int
}