package com.omersungur.omer_sungur_odev_10.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.omersungur.omer_sungur_odev_10.data.local.database.note.NoteDao
import com.omersungur.omer_sungur_odev_10.data.local.database.note.entity.NoteEntity
import com.omersungur.omer_sungur_odev_10.data.local.database.user.UserDao
import com.omersungur.omer_sungur_odev_10.data.local.database.user.entity.UserEntity

@Database(entities = [NoteEntity::class, UserEntity::class], version = 1)
abstract class ToDoDatabase : RoomDatabase() {

    abstract fun userDao() : UserDao
    abstract fun noteDao() : NoteDao
}