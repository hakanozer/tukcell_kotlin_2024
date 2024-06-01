package com.emrecura.homework_10.services

import android.content.ContentValues
import android.content.Context
import com.emrecura.homework_10.database.DB
import com.emrecura.homework_10.model.UserModel

class UserService(context: Context) : DB(context) {

    fun addUser(email: String, username: String, password: String): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put("email", email)
            put("username", username)
            put("password", password)
        }
        val effectRow = db.insert("user", null, values)
        db.close()
        return effectRow
    }

    fun deleteUser(uid: Int): Int {
        val db = this.writableDatabase
        val status = db.delete("user", "uid = ?", arrayOf(uid.toString()))
        db.close()
        return status
    }



    fun authenticateUser(email: String, password: String): UserModel? {
        val db = this.readableDatabase
        val cursor = db.query(
            "user", null, "email = ? AND password = ?",
            arrayOf(email, password), null, null, null
        )

        var user: UserModel? = null
        if (cursor.moveToFirst()) {
            val uid = cursor.getInt(cursor.getColumnIndexOrThrow("uid"))
            val email = cursor.getString(cursor.getColumnIndexOrThrow("email"))
            val username = cursor.getString(cursor.getColumnIndexOrThrow("username"))
            val userPassword = cursor.getString(cursor.getColumnIndexOrThrow("password"))
            user = UserModel(uid, email, username, userPassword)
        }
        cursor.close()
        db.close()
        return user
    }

}
