package com.tlh.noteapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tlh.noteapp.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

}