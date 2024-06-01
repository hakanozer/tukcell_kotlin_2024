package com.canerdedeoglu.odev10.services

import android.content.ContentValues
import android.content.Context
import com.canerdedeoglu.odev10.configs.DB
import com.canerdedeoglu.odev10.models.User

class UserService(context: Context) : DB(context) {

    fun addUser(name: String, surname: String, email: String, userName: String, password: String): Long {
        val db = writableDatabase
        val values = ContentValues()
        values.put("name", name)
        values.put("surname", surname)
        values.put("email", email)
        values.put("userName", userName)
        values.put("password", password)

        val effectRow = db.insert("User", null, values)
        //db.close()
        return effectRow
    }

    fun deleteUser(userId: Int): Int {
        val db = writableDatabase
        val effectRow = db.delete("User", "userId = ?", arrayOf(userId.toString()))
        //db.close()
        return effectRow
    }

    fun updateUser(userId: Int, name: String, surname: String, email: String, userName: String, password: String): Int {
        val db = writableDatabase

        val values = ContentValues()
        values.put("name", name)
        values.put("surname", surname)
        values.put("email", email)
        values.put("userName", userName)
        values.put("password", password)

        val effectRow = db.update("User", values, "userId = ?", arrayOf(userId.toString()))
        //db.close()
        return effectRow
    }

    fun getAllUser(): List<User> {
        val db = readableDatabase
        val userList = ArrayList<User>()
        val cursor = db.rawQuery("SELECT * FROM User", null)

        while (cursor.moveToNext()) {
            val userId = cursor.getInt(cursor.getColumnIndexOrThrow("userId"))
            val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
            val surname = cursor.getString(cursor.getColumnIndexOrThrow("surname"))
            val email = cursor.getString(cursor.getColumnIndexOrThrow("email"))
            val userName = cursor.getString(cursor.getColumnIndexOrThrow("userName"))
            val password = cursor.getString(cursor.getColumnIndexOrThrow("password"))
            val user = User(userId, name, surname, email, userName, password)
            userList.add(user)
        }

        cursor.close()
        //db.close()
        return userList
    }

    fun getUser(identifier: String, password: String): User? {
        val db = readableDatabase
        val cursor = db.rawQuery(
            "SELECT * FROM User WHERE (userName = ? OR email = ?) AND password = ?",
            arrayOf(identifier, identifier, password)
        )

        if (cursor.moveToFirst()) {
            val userId = cursor.getInt(cursor.getColumnIndexOrThrow("userId"))
            val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
            val surname = cursor.getString(cursor.getColumnIndexOrThrow("surname"))
            val email = cursor.getString(cursor.getColumnIndexOrThrow("email"))
            val userNameDb = cursor.getString(cursor.getColumnIndexOrThrow("userName"))
            val passwordDb = cursor.getString(cursor.getColumnIndexOrThrow("password"))

            cursor.close()
            // db.close()

            return User(userId, name, surname, email, userNameDb, passwordDb)
        }

        cursor.close()
        //db.close()

        return null
    }
}