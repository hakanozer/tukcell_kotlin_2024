package com.example.odev10.configs

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

open class DB(context: Context) : SQLiteOpenHelper(context, dbName, null, dbVersion) {

    companion object {
        private const val dbName = "project.db"
        private const val dbVersion = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createUserTable = """
            CREATE TABLE "users" (
                "uid" INTEGER PRIMARY KEY AUTOINCREMENT,
                "username" TEXT NOT NULL,
                "password" TEXT NOT NULL
            );
        """

        val createNotesTable = """
            CREATE TABLE "notes" (
                "nid" INTEGER PRIMARY KEY AUTOINCREMENT,
                "title" TEXT,
                "content" TEXT
            );
        """

        db?.let {
            it.execSQL(createUserTable)
            it.execSQL(createNotesTable)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val dropUserTable = "DROP TABLE IF EXISTS users"
        val dropNotesTable = "DROP TABLE IF EXISTS notes"

        db?.let {
            it.execSQL(dropUserTable)
            it.execSQL(dropNotesTable)
            onCreate(it)
        }
    }
}
