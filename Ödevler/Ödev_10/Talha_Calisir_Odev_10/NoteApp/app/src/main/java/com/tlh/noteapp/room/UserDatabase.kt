package com.tlh.noteapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tlh.noteapp.model.Note
import com.tlh.noteapp.model.User

@Database(entities = [User::class], version = 1)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}