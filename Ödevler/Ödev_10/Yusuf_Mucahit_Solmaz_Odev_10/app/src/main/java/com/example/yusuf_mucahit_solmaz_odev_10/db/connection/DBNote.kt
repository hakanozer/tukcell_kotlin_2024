package com.example.yusuf_mucahit_solmaz_odev_10.db.connection

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

open class DBNote(context: Context):SQLiteOpenHelper(context, DBName,null, version) {

    companion object{
        private val DBName="notes.db"
        private val version=1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val contactSql="CREATE TABLE \"notes\" (\n" +
                "\t\"id\"\tINTEGER,\n" +
                "\t\"noteTitle\"\tTEXT,\n" +
                "\t\"note\"\tTEXT,\n" +
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