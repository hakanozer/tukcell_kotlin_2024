package com.example.odev_10.services

import android.content.ContentValues
import android.content.Context
import com.example.odev_10.configs.DB
import com.example.odev_10.models.Note

class NoteService(context : Context) : DB(context) {

    fun addNote(uid: Int, title: String, content: String): Long {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put("uid", uid)
        values.put("title", title)
        values.put("content", content)

        val effectRow = db.insert("notes", null, values)
        db.close()
        return effectRow
    }

    fun updateNote(nid: Int, title: String, content: String): Int {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put("title", title)
        values.put("content", content)
        val updateStatus = db.update("notes", values, "nid = $nid", null)
        db.close()
        return updateStatus
    }

    fun deleteNote(nid: Int): Int {
        val db = this.writableDatabase
        val deleteStatus = db.delete("notes", "nid = $nid", null)
        db.close()
        return deleteStatus
    }

    fun getAllNotes(uid: Int): List<Note> {
        val db = this.readableDatabase
        val notes = mutableListOf<Note>()
        val cursor = db.rawQuery("SELECT * FROM notes WHERE uid = ?", arrayOf(uid.toString()))
        while (cursor.moveToNext()) {
            val nid = cursor.getInt(cursor.getColumnIndexOrThrow("nid"))
            val title = cursor.getString(cursor.getColumnIndexOrThrow("title"))
            val content = cursor.getString(cursor.getColumnIndexOrThrow("content"))
            val note = Note(nid, uid, title, content)
            notes.add(note)
        }
        cursor.close()
        db.close()
        return notes
    }

    fun searchNotes(uid: Int, query: String): List<Note> {
        val db = this.readableDatabase
        val notes = mutableListOf<Note>()
        val cursor = db.rawQuery("SELECT * FROM notes WHERE uid = ? AND (title LIKE '%$query%' OR content LIKE '%$query%')", arrayOf(uid.toString()))
        while (cursor.moveToNext()) {
            val nid = cursor.getInt(cursor.getColumnIndexOrThrow("nid"))
            val title = cursor.getString(cursor.getColumnIndexOrThrow("title"))
            val content = cursor.getString(cursor.getColumnIndexOrThrow("content"))
            val note = Note(nid, uid, title, content)
            notes.add(note)
        }
        cursor.close()
        db.close()
        return notes
    }
}