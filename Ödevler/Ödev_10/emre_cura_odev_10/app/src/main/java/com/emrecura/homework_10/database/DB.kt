package com.emrecura.homework_10.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


open class DB(context: Context) : SQLiteOpenHelper(context, DBName, null, version) {

    companion object {
        private val DBName = "project.db"
        private val version = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val noteTable = "CREATE TABLE \"note\" (\n" +
                "\t\"nid\"\tINTEGER,\n" +
                "\t\"uid\"\tTEXT,\n" +
                "\t\"title\"\tTEXT,\n" +
                "\t\"detail\"\tTEXT,\n" +
                "\t\"date\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"nid\" AUTOINCREMENT)\n" +
                ");"

        val userTable = "CREATE TABLE \"user\" (\n" +
                "\t\"uid\"\tINTEGER,\n" +
                "\t\"email\"\tTEXT,\n" +
                "\t\"username\"\tTEXT,\n" +
                "\t\"password\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"uid\" AUTOINCREMENT)\n" +
                ");"

        db?.execSQL(noteTable)
        db?.execSQL(userTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val noteDropSql = "DROP TABLE IF EXISTS note"
        val userDropSql = "DROP TABLE IF EXISTS user"

        db?.execSQL(noteDropSql)
        db?.execSQL(userDropSql)

        onCreate(db)
    }

}