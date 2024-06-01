package com.example.odev10.configs

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

open class DBUser(context: Context):SQLiteOpenHelper(context,DBName,null,version) {

    companion object{
        private val DBName="task.db"
        private val version=1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val contactSql="CREATE TABLE \"users\" (\n" +
                "\t\"id\"\tINTEGER,\n" +
                "\t\"name\"\tTEXT,\n" +
                "\t\"password\"\tINTEGER,\n" +
                "\tPRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
                ");"
        db?.let {
            it.execSQL(contactSql)
        }

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        val contanctDropSql = "drop table if exists users"
        db?.let {
            it.execSQL(contanctDropSql)
            onCreate(it)
        }
    }
}