package com.tlh.noteapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.tlh.noteapp.model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM User WHERE user_name = :name LIMIT 1")
     fun readUserByName(name: String): User?

    @Insert
    fun insert(user: User)

    @Delete
    fun delete(user: User)
}