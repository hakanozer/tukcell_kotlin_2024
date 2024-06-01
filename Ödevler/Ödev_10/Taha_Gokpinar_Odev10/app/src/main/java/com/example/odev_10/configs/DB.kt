package com.example.odev_10.configs

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

open class DB(context : Context) : SQLiteOpenHelper(context, DBName, null, version) {

    companion object {
        private  val DBName = "users_note.db"
        private  val version = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val usersSql = "CREATE TABLE \"users\" (\n" +
                "\t\"uid\"\tINTEGER,\n" +
                "\t\"username\"\tTEXT UNIQUE,\n" +
                "\t\"password\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"uid\" AUTOINCREMENT)\n" +
                ");"

        val notesSql = "CREATE TABLE \"notes\" (\n" +
                "\t\"nid\"\tINTEGER,\n" +
                "\t\"uid\"\tINTEGER,\n" +
                "\t\"title\"\tTEXT,\n" +
                "\t\"content\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"nid\" AUTOINCREMENT),\n" +
                "\tFOREIGN KEY(\"uid\") REFERENCES \"users\"(\"uid\")\n" +
                ");"

        db?.let {
            it.execSQL(usersSql)
            it.execSQL(notesSql)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val usersDropSql = "DROP TABLE IF EXISTS users"
        val notesDropSql = "DROP TABLE IF EXISTS notes"
        db?.let {
            it.execSQL(usersDropSql)
            it.execSQL(notesDropSql)
            onCreate(it)
        }
    }
}