package com.mai.maidebeyzabulbul_odev10

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.ContactsContract

class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "notes.db"
        private const val DATABASE_VERSION = 1

        private const val TABLE_USERS = "users"
        private const val TABLE_NOTES = "notes"

        private const val COLUMN_USER_ID = "id"
        private const val COLUMN_USER_NAME = "username"
        private const val COLUMN_USER_PASSWORD = "password"

        private const val COLUMN_NOTE_ID = "id"
        private const val COLUMN_NOTE_USER_ID = "user_id"
        private const val COLUMN_NOTE_TITLE = "title"
        private const val COLUMN_NOTE_CONTENT = "content"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createUsersTable = ("CREATE TABLE " + TABLE_USERS + "("
                + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_USER_NAME + " TEXT,"
                + COLUMN_USER_PASSWORD + " TEXT" + ")")

        val createNotesTable = ("CREATE TABLE " + TABLE_NOTES + "("
                + COLUMN_NOTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NOTE_USER_ID + " INTEGER,"
                + COLUMN_NOTE_TITLE + " TEXT,"
                + COLUMN_NOTE_CONTENT + " TEXT" + ")")

        db?.execSQL(createUsersTable)
        db?.execSQL(createNotesTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_USERS")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NOTES")
        onCreate(db)
    }

    fun insertUser(username: String, password: String): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COLUMN_USER_NAME, username)
        contentValues.put(COLUMN_USER_PASSWORD, password)
        return db.insert(TABLE_USERS, null, contentValues)
    }

    fun getUserId(username: String): Int {
        val db = this.readableDatabase
        val cursor = db.query(TABLE_USERS, arrayOf(COLUMN_USER_ID), "$COLUMN_USER_NAME=?", arrayOf(username), null, null, null)
        var userId = -1
        if (cursor.moveToFirst()) {
            userId = cursor.getInt(cursor.getColumnIndex(COLUMN_USER_ID))
        }
        cursor.close()
        return userId
    }

    fun insertNote(userId: Int, title: String, content: String): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COLUMN_NOTE_USER_ID, userId)
        contentValues.put(COLUMN_NOTE_TITLE, title)
        contentValues.put(COLUMN_NOTE_CONTENT, content)
        return db.insert(TABLE_NOTES, null, contentValues)
    }

    fun getNotes(userId: Int): List<Note> {
        val notes = mutableListOf<Note>()
        val db = this.readableDatabase
        val cursor = db.query(TABLE_NOTES, null, "$COLUMN_NOTE_USER_ID=?", arrayOf(userId.toString()), null, null, null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex(COLUMN_NOTE_ID))
                val title = cursor.getString(cursor.getColumnIndex(COLUMN_NOTE_TITLE))
                val content = cursor.getString(cursor.getColumnIndex(COLUMN_NOTE_CONTENT))
                notes.add(Note(id, userId, title, content))
            } while (cursor.moveToNext())
        }
        cursor.close()
        return notes
    }

    fun searchNotes(userId: Int, query: String): List<Note> {
        val notes = mutableListOf<Note>()
        val db = this.readableDatabase
        val cursor = db.query(TABLE_NOTES, null, "$COLUMN_NOTE_USER_ID=? AND ($COLUMN_NOTE_TITLE LIKE ? OR $COLUMN_NOTE_CONTENT LIKE ?)", arrayOf(userId.toString(), "%$query%", "%$query%"), null, null, null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex(COLUMN_NOTE_ID))
                val title = cursor.getString(cursor.getColumnIndex(COLUMN_NOTE_TITLE))
                val content = cursor.getString(cursor.getColumnIndex(COLUMN_NOTE_CONTENT))
                notes.add(Note(id, userId, title, content))
            } while (cursor.moveToNext())
        }
        cursor.close()
        return notes
    }
    fun getUser(username: String, password: String): Boolean {
        val db = this.readableDatabase
        val selection = "$COLUMN_USER_NAME = ? AND $COLUMN_USER_PASSWORD = ?"
        val selectionArgs = arrayOf(username, password)
        val cursor = db.query(TABLE_USERS, null, selection, selectionArgs, null, null, null)
        val result = cursor.count > 0
        cursor.close()
        return result
    }
}