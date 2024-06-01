package com.bengisusahin.odev_10.services

import android.content.ContentValues
import android.content.Context
import com.bengisusahin.odev_10.configs.DB
import com.bengisusahin.odev_10.models.User

class UserService(context: Context) : DB(context) {
    // add user to the database
    fun addUser(user: User): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_USERNAME, user.username)
            put(COLUMN_PASSWORD, user.password)
        }
        val effectRow = db.insert(TABLE_USERS, null, values)
        db.close()
        return effectRow
    }

    // check if the user exists in the database
    fun getUser(username: String, password: String): User? {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_USERS WHERE $COLUMN_USERNAME = ? AND $COLUMN_PASSWORD = ?", arrayOf(username, password))
        val user = if (cursor.moveToFirst()) {
            User(
                id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_USER_ID)),
                username = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_USERNAME)),
                password = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PASSWORD))
            )
        } else {
            null
        }
        cursor.close()
        db.close()
        return user
    }
}