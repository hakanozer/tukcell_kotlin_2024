package com.yeceylan.yunusemreceylan_odev10.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yeceylan.yunusemreceylan_odev10.model.dao.NoteDao
import com.yeceylan.yunusemreceylan_odev10.model.dao.UserDao
import com.yeceylan.yunusemreceylan_odev10.model.entity.Note
import com.yeceylan.yunusemreceylan_odev10.model.entity.User

@Database(entities = [User::class, Note::class], exportSchema = false, version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun noteDao(): NoteDao
}

