package com.example.eray_altilar_odev_10.config

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

open class DB(context: Context) : SQLiteOpenHelper(context, DBName, null, version) {

    companion object {
        private const val DBName = "simpleray.db"
        private const val version = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val usersSql = """
            CREATE TABLE "Users" (
                "cid" INTEGER PRIMARY KEY AUTOINCREMENT,
                "username" TEXT,
                "password" TEXT,
                "notes" TEXT
            );
        """.trimIndent()

        val notesSql = """
            CREATE TABLE "Notes" (
            	"nid" INTEGER  PRIMARY KEY AUTOINCREMENT,
	            "cid"	INTEGER,
	            "noteTitle"	TEXT
            );
        """.trimIndent()

        db?.execSQL(usersSql)
        db?.execSQL(notesSql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val userDropSql = "DROP TABLE IF EXISTS Users"
        val notesDropSql = "DROP TABLE IF EXISTS Notes"
        db?.let {
            it.execSQL(userDropSql)
            it.execSQL(notesDropSql)
            onCreate(it)
        }
    }
}
