package com.example.homework10.configs

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

open class UserDataBaseHelper(context:Context): SQLiteOpenHelper(context, DATABASE_NAME,null,
    DATABASE_VERSION) {


    companion object {
         const val DATABASE_NAME = "users.db"
         const val DATABASE_VERSION = 1
         const val TABLE_USERS = "users"
         const val COLUMN_ID = "id"
         const val COLUMN_USERNAME = "username"
         const val COLUMN_PASSWORD = "password"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_USERS_TABLE = ("CREATE TABLE $TABLE_USERS ("
                + "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "$COLUMN_USERNAME TEXT,"
                + "$COLUMN_PASSWORD TEXT)")
        db.execSQL(CREATE_USERS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_USERS")
        onCreate(db)
    }
}