package com.canerdedeoglu.odev10.configs

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

open class DB(context: Context) :SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION)
{
    companion object
    {
        private val DB_NAME = "odev10.db"
        private val DB_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {

        val userTable = "CREATE TABLE \"User\" (\n" +
                "\t\"userId\"\tINTEGER,\n" +
                "\t\"name\"\tTEXT,\n" +
                "\t\"surname\"\tTEXT,\n" +
                "\t\"email\"\tTEXT,\n" +
                "\t\"userName\"\tTEXT UNIQUE,\n" +
                "\t\"password\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"userId\" AUTOINCREMENT)\n" +
                ");"

        val noteTable = "CREATE TABLE \"Notes\" (\n" +
                "\t\"noteId\"\tINTEGER,\n" +
                "\t\"title\"\tTEXT NOT NULL,\n" +
                "\t\"description\"\tTEXT,\n" +
                "\t\"date\"\tTEXT,\n" +
                "\t\"category\"\tTEXT,\n" +
                "\t\"userId\"\tINTEGER,\n" +
                "\tPRIMARY KEY(\"noteId\" AUTOINCREMENT),\n" +
                "\tFOREIGN KEY(\"userId\") REFERENCES \"User\"(\"userId\")\n" +
                ");"

        db?.execSQL(userTable)
        db?.execSQL(noteTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        db?.execSQL("DROP TABLE IF EXISTS User")
        db?.execSQL("DROP TABLE IF EXISTS Notes")
        onCreate(db)
    }
}