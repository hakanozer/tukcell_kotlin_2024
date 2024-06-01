package com.example.emre_bitik_odev_10.configs

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


open class DB(context: Context): SQLiteOpenHelper(context, DBName, null, version)
{
    companion object{
        private val DBName = "project.db"
        private  val version = 1


    }

    override fun onCreate(db: SQLiteDatabase?) {
        val contactsSql = "CREATE TABLE \"notes\" (\n" +
                "\t\"cid\"\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t\"title\"\tTEXT,\n" +
                "\t\"detail\"\tTEXT\n" +
                ");"
        val userSql = "CREATE TABLE \"users\" (\n" +
                "\t\"cid\"\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t\"username\"\tTEXT,\n" +
                "\t\"password\"\tTEXT\n" +
                ");"
        db?.let {
            it.execSQL(contactsSql)
            it.execSQL(userSql)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val contactDropSql = "drop table if exists notes"
        val userDropSql = "drop table if exists users"
        db?.let {
            it.execSQL(contactDropSql)
            it.execSQL(userDropSql)
        }
    }


}