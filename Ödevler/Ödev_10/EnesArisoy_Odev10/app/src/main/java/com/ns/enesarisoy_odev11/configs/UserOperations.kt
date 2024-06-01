package com.ns.enesarisoy_odev11.configs

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.ns.enesarisoy_odev11.model.User

class UserOperations(context: Context) {

    private val dbHelper = DatabaseHelper(context)

    fun checkUser(username: String): Boolean {
        val db: SQLiteDatabase = dbHelper.readableDatabase
        val cursor: Cursor = db.query(
            "users", arrayOf("id", "username", "password"),
            "username=?", arrayOf(username), null, null, null
        )
        return cursor != null && cursor.moveToFirst()
    }

    fun registerUser(username: String, password: String): Long {
        val db: SQLiteDatabase = dbHelper.writableDatabase
        val values = ContentValues()
        values.put("username", username)
        values.put("password", password)
        return db.insert("users", null, values)
    }

    fun loginUser(username: String, password: String): User? {
        val db: SQLiteDatabase = dbHelper.readableDatabase
        val cursor: Cursor = db.query(
            "users", arrayOf("id", "username", "password"),
            "username=? AND password=?", arrayOf(username, password), null, null, null
        )
        return if (cursor != null && cursor.moveToFirst()) {
            val userId = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
            val userUsername = cursor.getString(cursor.getColumnIndexOrThrow("username"))
            val userPassword = cursor.getString(cursor.getColumnIndexOrThrow("password"))
            cursor.close()
            User(userId, userUsername, userPassword)
        } else {
            cursor?.close()
            null
        }
    }
}