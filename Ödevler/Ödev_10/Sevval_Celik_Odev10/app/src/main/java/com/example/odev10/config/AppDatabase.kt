package com.example.odev10.config
import androidx.room.Database

import androidx.room.RoomDatabase
import com.example.odev10.dao.NotesDao
import com.example.odev10.dao.UserDao
import com.example.odev10.entitie.User


@Database(entities = [User::class, com.example.odev10.entitie.Note::class], version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun noteDao(): NotesDao


}
