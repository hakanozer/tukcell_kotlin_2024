package com.example.odev10.configs

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

open class DBNotes(context: Context):SQLiteOpenHelper(context, DBName,null, version) {

    companion object{
        private val DBName="notes.db"
        private val version=1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val contactSql="CREATE TABLE \"notes\" (\n" +
                "\t\"id\"\tINTEGER,\n" +
                "\t\"lessonName\"\tTEXT,\n" +
                "\t\"note\"\tINTEGER,\n" +
                "\tPRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
                ");"

        db?.let {
            it.execSQL(contactSql)

        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        val contanctDropSql = "drop table if exists notes"
        db?.let {
            it.execSQL(contanctDropSql)
            onCreate(it)
        }
    }


}