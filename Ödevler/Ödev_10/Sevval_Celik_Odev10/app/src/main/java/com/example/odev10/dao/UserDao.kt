package com.example.odev10.dao
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.odev10.entitie.User

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User): Long
    @Query("SELECT * FROM users WHERE username = :username AND password = :password")
    suspend fun getUser(username: String, password: String): User?

    @Query("SELECT * FROM users WHERE isRegister = 1 LIMIT 1")
    suspend fun getRegisteredUser(): User?

    @Query("UPDATE users SET isRegister = :isRegister WHERE username = :username")
    suspend fun updateUser(username: String, isRegister: Boolean)
}