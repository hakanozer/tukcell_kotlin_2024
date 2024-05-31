package com.example.homework10.configs

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

open class ToDoDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
         const val DATABASE_NAME = "todos.db"
         const val DATABASE_VERSION = 1
         const val TABLE_TODOS = "todos"
         const val COLUMN_USER_ID = "user_id"
         const val COLUMN_ID = "id"
         const val COLUMN_TASK = "task"
         const val COLUMN_COMPLETED = "completed"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_TODOS_TABLE = ("CREATE TABLE $TABLE_TODOS ("
                + "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"$COLUMN_USER_ID INTEGER,"
                + "$COLUMN_TASK TEXT,"
                + "$COLUMN_COMPLETED INTEGER DEFAULT 0)")
        db.execSQL(CREATE_TODOS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_TODOS")
        onCreate(db)
    }

}