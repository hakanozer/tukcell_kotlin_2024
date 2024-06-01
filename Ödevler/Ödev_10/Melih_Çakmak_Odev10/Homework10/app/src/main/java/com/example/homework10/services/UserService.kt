package com.example.homework10.services

import android.content.ContentValues
import android.content.Context
import com.example.homework10.configs.UserDataBaseHelper
import com.example.homework10.models.Todo
import com.example.homework10.models.User

class UserService(context:Context):UserDataBaseHelper(context) {

    fun addUser(user: User): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put(COLUMN_USERNAME, user.username)
            put(COLUMN_PASSWORD, user.password)
        }
        return db.insert(TABLE_USERS, null, contentValues)
    }

    fun getUser(username: String, password: String): Int {
        val db = this.readableDatabase
        val cursor = db.query(
            TABLE_USERS,
            arrayOf(COLUMN_ID),
            "$COLUMN_USERNAME=? AND $COLUMN_PASSWORD=?",
            arrayOf(username, password),
            null,
            null,
            null
        )
        val userId = if (cursor.moveToFirst()) {
            cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID))
        } else {
            -1
        }
        cursor.close()
        return userId
    }







}