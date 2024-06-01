package com.toren.odev10.data.local.dao

import android.content.ContentValues
import android.content.Context
import com.toren.odev10.data.local.db.DatabaseHelper
import com.toren.odev10.domain.model.Note

class NoteDao(context: Context) : DatabaseHelper(context) {

    fun addNote(title: String, note: String, userId: Int): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(NOTE_TABLE_TITLE_COLUMN, title)
            put(NOTE_TABLE_NOTE_COLUMN, note)
            put(NOTE_TABLE_USER_ID_COLUMN, userId)
        }
        return db.insert(NOTE_TABLE_NAME, null, values)
    }

    fun updateNote(title: String, note: String, id: Int): Int {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(NOTE_TABLE_TITLE_COLUMN, title)
            put(NOTE_TABLE_NOTE_COLUMN, note)
            put(NOTE_TABLE_ID_COLUMN, id)
        }
        return db.update(NOTE_TABLE_NAME, values, "$NOTE_TABLE_ID_COLUMN = ?", arrayOf(id.toString()))
    }

    fun deleteNote(id: Int): Int {
        val db = writableDatabase
        return db.delete(NOTE_TABLE_NAME, "$NOTE_TABLE_ID_COLUMN = ?", arrayOf(id.toString()))
    }

    fun getNotes(userId: Int): List<Note> {
        val noteList = mutableListOf<Note>()
        val db = readableDatabase
        val columns = arrayOf(
            NOTE_TABLE_ID_COLUMN,
            NOTE_TABLE_TITLE_COLUMN,
            NOTE_TABLE_NOTE_COLUMN
        )
        val selection = "$NOTE_TABLE_USER_ID_COLUMN = ?"
        val selectionArgs = arrayOf(userId.toString())
        val cursor = db.query(
            NOTE_TABLE_NAME,
            columns,
            selection,
            selectionArgs,
            null,
            null,
            null
        )
        if (cursor != null && cursor.moveToFirst()) {
            do {
                val note = Note(
                    id = cursor.getInt(cursor.getColumnIndexOrThrow(NOTE_TABLE_ID_COLUMN)),
                    title = cursor.getString(cursor.getColumnIndexOrThrow(NOTE_TABLE_TITLE_COLUMN)),
                    note = cursor.getString(cursor.getColumnIndexOrThrow(NOTE_TABLE_NOTE_COLUMN)),
                    userId = userId
                )
                noteList.add(note)
            } while (cursor.moveToNext())
        }
        cursor.close()
        return noteList
    }
}