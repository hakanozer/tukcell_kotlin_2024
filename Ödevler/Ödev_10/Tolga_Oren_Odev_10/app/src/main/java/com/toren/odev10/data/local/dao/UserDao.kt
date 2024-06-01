package com.toren.odev10.data.local.dao

import android.content.ContentValues
import android.content.Context
import com.toren.odev10.data.local.db.DatabaseHelper
import com.toren.odev10.domain.model.User

class UserDao(context: Context) : DatabaseHelper(context) {

    fun addUser(user: User): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(USER_TABLE_NAME_COLUMN, user.username)
            put(USER_TABLE_PASSWORD_COLUMN, user.password)
        }
        return db.insert(USER_TABLE_NAME, null, values)
    }

    fun authenticateUser(username: String, password: String): Pair<Boolean, Int?> {
        val db = readableDatabase
        val columns = arrayOf(USER_TABLE_ID_COLUMN)
        val selection = "$USER_TABLE_NAME_COLUMN = ? AND $USER_TABLE_PASSWORD_COLUMN = ?"
        val selectionArgs = arrayOf(username, password)
        val cursor = db.query(
            USER_TABLE_NAME,
            columns,
            selection,
            selectionArgs,
            null,
            null,
            null
        )
        val userId: Int? = if (cursor.moveToFirst()) {
            cursor.getInt(cursor.getColumnIndexOrThrow(USER_TABLE_ID_COLUMN))
        } else {
            null
        }
        cursor.close()
        val isAuthenticated = userId != null
        return Pair(isAuthenticated, userId)
    }

}