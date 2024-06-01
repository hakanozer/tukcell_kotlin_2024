package com.ns.enesarisoy_odev11.configs

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "notes_app.db"
        private const val DATABASE_VERSION = 1

        private const val TABLE_NOTES = "notes"
        private const val TABLE_USERS = "users"

        private const val CREATE_TABLE_NOTES =
            "CREATE TABLE $TABLE_NOTES (id INTEGER PRIMARY KEY AUTOINCREMENT, user_id INTEGER, title TEXT, content TEXT)"
        private const val CREATE_TABLE_USERS =
            "CREATE TABLE $TABLE_USERS (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_NOTES)
        db.execSQL(CREATE_TABLE_USERS)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NOTES")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_USERS")
        onCreate(db)
    }
}