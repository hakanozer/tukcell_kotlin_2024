package com.beyzaparlak.notesapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.beyzaparlak.notesapp.entities.User

@Dao
interface UsersDao {

    // return id döndürür
    @Insert
    fun insert(user: User): Long

    // kullanıcının şifre ve kullanıcı adını arama
    @Query("SELECT * FROM users WHERE username = :username AND password = :password")
    fun getUser(username: String, password: String): User?


    @Query("SELECT * FROM users WHERE isRegister = 1 LIMIT 1")
    fun getRegisteredUser(): User?

    // Kullanıcı önceden kayıt oluşturdu mu kontrolü
    @Query("UPDATE users SET isRegister = :isRegister WHERE username = :username")
    fun updateUser(username: String, isRegister: Boolean)
}