package com.example.odev10.services

import android.content.ContentValues
import android.content.Context
import com.example.odev10.configs.DB

class UserService(context: Context) : DB(context) {


    fun addUser(username: String, password: String): Long {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put("username", username)
        values.put("password", password)
        val effectRow = db.insert("users", null, values)
        db.close()
        return effectRow
    }


    fun isUserRegistered(): Boolean {
        val db = this.readableDatabase
        val cursor = db.query("users", arrayOf("uid"), null, null, null, null, null)
        val count = cursor.count
        cursor.close()
        db.close()
        return count > 0
    }

    fun getSingleUser(username: String, password: String): Boolean {
        val db = this.readableDatabase
        val cursor = db.rawQuery(
            "SELECT * FROM users WHERE username = ? AND password = ?",
            arrayOf(username, password)
        )
        val exists = cursor.moveToFirst()
        cursor.close()
        db.close()
        return exists
    }

}
