package com.muratdayan.odev10.configs

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

open class NotesDB(context: Context) :  SQLiteOpenHelper(context, DBName, null, version) {

    companion object{
        private val DBName = "notes.db"
        private val version = 2
    }

    override fun onCreate(db: SQLiteDatabase?) {
        // Veritabanı oluşturma
        val createUserTableSql = "CREATE TABLE \"user\" (\n" +
                "\t\"uid\"\tINTEGER,\n" +
                "\t\"username\"\tTEXT,\n" +
                "\t\"password\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"uid\" AUTOINCREMENT)\n" +
                ");"

        val createNoteTableSql = "CREATE TABLE \"note\" (\n" +
                "\t\"nid\"\tINTEGER,\n" +
                "\t\"title\"\tTEXT,\n" +
                "\t\"detail\"\tTEXT,\n" +
                "\t\"priority\"\tINTEGER,\n" +
                "\t\"date\"\tTEXT,\n" +
                "\t\"isDone\"\tINTEGER,\n" +  // isDone INTEGER türünde olarak tanımlanıyor
                "\tPRIMARY KEY(\"nid\" AUTOINCREMENT)\n" +
                ");"

        db?.execSQL(createUserTableSql)
        db?.execSQL(createNoteTableSql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // Veritabanı güncelleme
        val userTableDropSql = "DROP TABLE IF EXISTS user"
        val noteTableDropSql = "DROP TABLE IF EXISTS note"
        db?.execSQL(userTableDropSql)
        db?.execSQL(noteTableDropSql)
        onCreate(db)
    }
}