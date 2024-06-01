package com.toren.odev10.data.local.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

open class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "todoapp.db"
        private const val DATABASE_VERSION = 1
    }

    protected val USER_TABLE_NAME = "user"
    protected val USER_TABLE_ID_COLUMN = "uid"
    protected val USER_TABLE_NAME_COLUMN = "username"
    protected val USER_TABLE_PASSWORD_COLUMN = "password"

    protected val NOTE_TABLE_NAME = "notes"
    protected val NOTE_TABLE_ID_COLUMN = "nid"
    protected val NOTE_TABLE_TITLE_COLUMN = "title"
    protected val NOTE_TABLE_NOTE_COLUMN = "note"
    protected val NOTE_TABLE_USER_ID_COLUMN = "uid"
    override fun onCreate(db: SQLiteDatabase?) {
        val createTableUser = buildString {
            append("CREATE TABLE \"$USER_TABLE_NAME\" (\n")
            append("\t\"$USER_TABLE_ID_COLUMN\"\tINTEGER,\n")
            append("\t\"$USER_TABLE_NAME_COLUMN\"\tTEXT,\n")
            append("\t\"$USER_TABLE_PASSWORD_COLUMN\"\tTEXT,\n")
            append("\tPRIMARY KEY(\"$USER_TABLE_ID_COLUMN\" AUTOINCREMENT)\n")
            append(");")
        }

        val createTableNotes = buildString {
            append("CREATE TABLE \"$NOTE_TABLE_NAME\" (\n")
            append("\t\"$NOTE_TABLE_ID_COLUMN\"\tINTEGER,\n")
            append("\t\"$NOTE_TABLE_TITLE_COLUMN\"\tTEXT,\n")
            append("\t\"$NOTE_TABLE_NOTE_COLUMN\"\tTEXT,\n")
            append("\t\"$NOTE_TABLE_USER_ID_COLUMN\"\tINTEGER,\n")
            append("\tPRIMARY KEY(\"$NOTE_TABLE_ID_COLUMN\" AUTOINCREMENT)\n")
            append(");")
        }

        db?.execSQL(createTableNotes)
        db?.execSQL(createTableUser)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL(buildString {
        append("DROP TABLE IF EXISTS user")
    })
        db?.execSQL(buildString {
        append("DROP TABLE IF EXISTS notes")
    })
        onCreate(db)
    }


}