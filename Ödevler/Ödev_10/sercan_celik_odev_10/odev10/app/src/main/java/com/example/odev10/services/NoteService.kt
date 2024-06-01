package com.example.odev10.services

import android.content.ContentValues
import android.content.Context
import com.example.odev10.models.Note
import com.example.odev10.configs.DB

class NoteService(context: Context) : DB(context) {
    fun addNote(title: String, content: String): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put("title", title)
            put("content", content)
        }
        val effectRow = db.insert("notes", null, values)
        db.close()
        return effectRow
    }

    fun deleteNote(nid: Int): Int {
        val db = this.writableDatabase
        val deleteStatus = db.delete("notes", "nid = ?", arrayOf(nid.toString()))
        db.close()
        return deleteStatus
    }

    fun updateNote(title: String, content: String, nid: Int): Int {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put("title", title)
            put("content", content)
        }
        val status = db.update("notes", values, "nid = ?", arrayOf(nid.toString()))
        db.close()
        return status
    }

    fun getAllNotes(): MutableList<Note> {
        val db = this.readableDatabase
        val arr = mutableListOf<Note>()
        db.rawQuery("SELECT * FROM notes", null)?.use { cursor ->
            while (cursor.moveToNext()) {
                val nid = cursor.getInt(cursor.getColumnIndexOrThrow("nid"))
                val title = cursor.getString(cursor.getColumnIndexOrThrow("title"))
                val content = cursor.getString(cursor.getColumnIndexOrThrow("content"))
                arr.add(Note(nid, title, content))
            }
        }
        return arr
    }

    fun searchNote(q: String): List<Note> {
        val db = this.readableDatabase
        val arr = mutableListOf<Note>()
        val cursor = db.rawQuery(
            "SELECT * FROM notes WHERE title LIKE ? OR content LIKE ?",
            arrayOf("%$q%", "%$q%")
        )
        cursor.use {
            while (cursor.moveToNext()) {
                val nid = cursor.getInt(cursor.getColumnIndexOrThrow("nid"))
                val title = cursor.getString(cursor.getColumnIndexOrThrow("title"))
                val content = cursor.getString(cursor.getColumnIndexOrThrow("content"))
                arr.add(Note(nid, title, content))
            }
        }
        return arr
    }
}
