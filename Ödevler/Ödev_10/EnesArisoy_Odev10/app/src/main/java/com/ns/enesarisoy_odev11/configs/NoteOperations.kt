package com.ns.enesarisoy_odev11.configs

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.ns.enesarisoy_odev11.model.Note

class NoteOperations(context: Context) {

    private val dbHelper = DatabaseHelper(context)

    fun addNote(userId: Int, title: String, content: String): Long {
        val db: SQLiteDatabase = dbHelper.writableDatabase
        val values = ContentValues()
        values.put("user_id", userId)
        values.put("title", title)
        values.put("content", content)
        return db.insert("notes", null, values)
    }

    fun updateNote(userId: Int, id: Int, title: String, content: String): Int {
        val db: SQLiteDatabase = dbHelper.writableDatabase
        val values = ContentValues()
        values.put("title", title)
        values.put("content", content)
        return db.update(
            "notes",
            values,
            "id=? AND user_id=?",
            arrayOf(id.toString(), userId.toString())
        )
    }

    fun deleteNote(userId: Int, id: Int): Int {
        val db: SQLiteDatabase = dbHelper.writableDatabase
        return db.delete("notes", "id=? AND user_id=?", arrayOf(id.toString(), userId.toString()))
    }

    fun getAllNotes(userId: Int): List<Note> {
        val notes = ArrayList<Note>()
        val db: SQLiteDatabase = dbHelper.readableDatabase
        val cursor: Cursor = db.query(
            "notes", arrayOf("id", "title", "content"),
            "user_id=?", arrayOf(userId.toString()), null, null, null
        )
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                val title = cursor.getString(cursor.getColumnIndexOrThrow("title"))
                val content = cursor.getString(cursor.getColumnIndexOrThrow("content"))
                notes.add(Note(id, title, content))
            } while (cursor.moveToNext())
        }
        cursor.close()
        return notes
    }

    fun searchNotes(userId: Int, query: String): List<Note> {
        val notes = ArrayList<Note>()
        val db: SQLiteDatabase = dbHelper.readableDatabase
        val cursor: Cursor = db.rawQuery(
            "SELECT * FROM notes WHERE user_id=? AND (title LIKE ? OR content LIKE ?)",
            arrayOf(userId.toString(), "%$query%", "%$query%")
        )
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                val title = cursor.getString(cursor.getColumnIndexOrThrow("title"))
                val content = cursor.getString(cursor.getColumnIndexOrThrow("content"))
                notes.add(Note(id, title, content))
            } while (cursor.moveToNext())
        }
        cursor.close()
        return notes
    }

    fun getNoteById(userId: Int, id: Int): Note? {
        val db: SQLiteDatabase = dbHelper.readableDatabase
        val cursor: Cursor = db.query(
            "notes", arrayOf("id", "title", "content"),
            "id=? AND user_id=?", arrayOf(id.toString(), userId.toString()), null, null, null
        )
        return if (cursor != null && cursor.moveToFirst()) {
            val noteId = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
            val title = cursor.getString(cursor.getColumnIndexOrThrow("title"))
            val content = cursor.getString(cursor.getColumnIndexOrThrow("content"))
            cursor.close()
            Note(noteId, title, content)
        } else {
            cursor?.close()
            null
        }
    }
}