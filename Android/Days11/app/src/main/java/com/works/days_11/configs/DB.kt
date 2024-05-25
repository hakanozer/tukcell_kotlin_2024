package com.works.days_11.configs

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Parcelable

open class DB(context: Context) : SQLiteOpenHelper(context, DBName, null, version) {

    companion object {
        private val DBName = "project.db"
        private val version = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val contactsSql = "CREATE TABLE \"contacts\" (\n" +
                "\t\"cid\"\tINTEGER,\n" +
                "\t\"name\"\tTEXT,\n" +
                "\t\"surname\"\tTEXT,\n" +
                "\t\"age\"\tINTEGER,\n" +
                "\t\"color\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"cid\" AUTOINCREMENT)\n" +
                ");"
        db?.let {
            it.execSQL(contactsSql)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val contanctDropSql = "drop table if exists contacts"
        db?.let {
            it.execSQL(contanctDropSql)
            onCreate(it)
        }
    }


}