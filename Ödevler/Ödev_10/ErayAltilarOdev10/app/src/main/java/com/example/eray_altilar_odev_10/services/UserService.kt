package com.example.eray_altilar_odev_10.services

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.example.eray_altilar_odev_10.R
import com.example.eray_altilar_odev_10.config.DB
import com.example.eray_altilar_odev_10.models.User
import com.example.eray_altilar_odev_10.models.Note

class UserService(context: Context) : DB(context)  {

    fun addUser(userName: String, password: String): Long {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put("userName", userName)
        values.put("password", password)
        val effectRow = db.insert("users", null, values)
        db.close()
        return effectRow
    }

    fun deleteUser(cid: Int): Int {
        val db = this.writableDatabase
        val effectRow = db.delete("users", "cid=?", arrayOf(cid.toString()))
        db.close()
        return effectRow
    }

    fun getAllUsers(): List<User> {
        val db = this.readableDatabase
        val arr = mutableListOf<User>()
        val cursor = db.rawQuery("SELECT * FROM users", null)
        if (cursor.count == 0) {
            println("Database is Empty")
        }
        while (cursor.moveToNext()) {
            val cid = cursor.getInt(0)
            val name = cursor.getString(1)
            val password = cursor.getString(2)
            val notes = mutableListOf<Note>()
            val u = User(cid, name, password, notes   )
            arr.add(u)
            Log.d("UserList", "$cid $name $password")
        }
        cursor.close()
        db.close()
        return arr
    }

    fun singleUser(username: String, password: String): User? {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM users WHERE userName=? AND password=?", arrayOf(username, password))
        if (cursor.moveToNext()) {
            val cid = cursor.getInt(0)
            val username = cursor.getString(1)
            val password = cursor.getString(2)
            val notes = mutableListOf<Note>()
            val u = User(cid, username, password , notes )
            cursor.close()
            db.close()
            return u
        }
        cursor.close()
        db.close()
        return null
    }

    fun addNote(cid: Int,title: String): Long {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put("cid", cid)
        values.put("noteTitle", title)
        val effectRow = db.insert("notes", null, values)
        db.close()
        return effectRow
    }

    fun getNotes(cid: Int): List<Note> {
        val db = this.readableDatabase
        val cursor = db.query(
                "notes",
                arrayOf("nid", "noteTitle"),
                "cid = ?",
                arrayOf(cid.toString()),
                null, null, null
        )

        val notes = mutableListOf<Note>()
        if (cursor.moveToFirst()) {
            do {
                val nid = cursor.getInt(cursor.getColumnIndexOrThrow("nid"))
                val noteTitle = cursor.getString(cursor.getColumnIndexOrThrow("noteTitle"))
                notes.add(Note(nid = nid, noteTitle = noteTitle , cid = cid))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return notes
    }

    fun deleteNote(nid: Int): Int {
        val db = this.writableDatabase
        val effectRow = db.delete("notes", "nid = ?", arrayOf(nid.toString()))
        db.close()
        return effectRow
    }

    fun updateNoteTitle(nid: Int, newTitle: String): Int {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put("noteTitle", newTitle)
        }

        val affectedRows = db.update("notes", values, "nid = ?", arrayOf(nid.toString()))
        db.close()
        return affectedRows
    }

    fun searchNotes(cid: Int, searchText: String): List<Note> {
        val notesList = mutableListOf<Note>()
        val db = this.readableDatabase

        val cursor = db.rawQuery(
            "SELECT * FROM notes WHERE cid = ? AND noteTitle LIKE ?",
            arrayOf(cid.toString(), "%$searchText%")
        )

        with(cursor) {
            while (moveToNext()) {
                val nid = getInt(getColumnIndexOrThrow("nid"))
                val noteTitle = getString(getColumnIndexOrThrow("noteTitle"))
                val note = Note(nid = nid, noteTitle = noteTitle , cid = cid)
                notesList.add(note)
            }
            close()
        }

        return notesList
    }

}
