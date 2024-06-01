package com.example.mustafakocerodev10.config

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mustafakocerodev10.dao.NotesDao
import com.example.mustafakocerodev10.dao.UserDao
import com.example.mustafakocerodev10.entity.Notes
import com.example.mustafakocerodev10.entity.User

@Database(entities = [User::class, Notes::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun createNotesDao() : NotesDao
    // db.createNotesDao() ile NotesDao interfacesinde tanımladığım metodları kullanabilirim

    abstract fun createUserDao() : UserDao
    // db.createUserDao() ile UserDao interfacesinde tanımladığım metodları kullanabilirim

}