package com.selincengiz.selin_cengiz_odev10.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.selincengiz.selin_cengiz_odev10.data.entities.NotesRoom
import com.selincengiz.selin_cengiz_odev10.data.entities.UserRoom

@Database(entities = [NotesRoom::class, UserRoom::class], version = 2)
abstract class NoteRoomDB : RoomDatabase() {
    abstract fun noteDao(): INotesDao
    abstract fun userDao(): IUserDao

}