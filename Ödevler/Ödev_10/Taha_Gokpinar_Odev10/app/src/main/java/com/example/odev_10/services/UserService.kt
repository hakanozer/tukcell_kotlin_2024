package com.example.odev_10.services

import android.content.ContentValues
import android.content.Context
import com.example.odev_10.configs.DB
import com.example.odev_10.models.User

class UserService(context : Context) : DB(context) {

    fun addUser(username: String, password: String): Long {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put("username", username)
        values.put("password", password)

        val effectRow = db.insert("users", null, values)
        db.close()
        return effectRow
    }

    fun getUser(username: String, password: String): User? {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM users WHERE username = ? AND password = ?", arrayOf(username, password))
        if (cursor.moveToFirst()) {
            val uid = cursor.getInt(cursor.getColumnIndexOrThrow("uid"))
            return User(uid, username, password)
        }
        db.close()
        return null
    }

    fun isUsernameExists(username: String): Boolean {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM users WHERE username = ?", arrayOf(username))
        val exists = cursor.count > 0
        cursor.close()
        db.close()
        return exists
    }
}