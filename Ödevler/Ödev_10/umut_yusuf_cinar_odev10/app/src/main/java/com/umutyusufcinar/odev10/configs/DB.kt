//adından da anlaşıacağı üzere local db dosyamız
//ders videolarını baz alarak ilerleyip eklemeler yapacağım
package com.umutyusufcinar.odev10.configs

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

open class DB(private val context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){
    //başlanguçta sınıfı olmayan bir veri tabanı nesnesi oluşturabilmek için companion kullanıyoruz
    companion object {
        private const val DATABASE_NAME = "user.db"
        private const val DATABASE_VERSION = 1
        
        const val TABLE_USERS = "users"
        const val COLUMN_USER_ID = "id"
        const val COLUMN_USERNAME = "username"
        const val COLUMN_PASSWORD = "password"

        const val TABLE_NOTES = "notes"
        const val COLUMN_NOTE_ID = "nid"
        const val COLUMN_USER_ID_FK = "uid"
        const val COLUMN_NOTE_TITLE = "title"
        const val COLUMN_NOTE_CONTENT = "content"
        const val COLUMN_NOTE_DATE = "date"
    }

    //veri tabanı ilk kez oluşuyorsa
    override fun onCreate(db: SQLiteDatabase?) {
        // primary key is a concept of SQL that uniquely identifies each item in a db table
        val createUserTableQuery = "CREATE TABLE $TABLE_USERS (" +
                "$COLUMN_USER_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_USERNAME TEXT, " +
                "$COLUMN_PASSWORD TEXT)"
        db?.execSQL(createUserTableQuery)

        val createNotesTableQuery = "CREATE TABLE $TABLE_NOTES (" +
                "$COLUMN_NOTE_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_USER_ID_FK INTEGER, " +
                "$COLUMN_NOTE_TITLE TEXT, " +
                "$COLUMN_NOTE_CONTENT TEXT," +
                "$COLUMN_NOTE_DATE TEXT, " +
                "FOREIGN KEY($COLUMN_USER_ID_FK) REFERENCES $TABLE_USERS($COLUMN_USER_ID))"
        db?.execSQL(createNotesTableQuery)
    }

    //veri tabanı daha önce oluşturulmuşsa
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val dropUserTableQuery = "DROP TABLE IF EXISTS $TABLE_USERS"
        val dropNoteTableQuery = "DROP TABLE IF EXISTS $TABLE_NOTES"
        db?.execSQL(dropUserTableQuery)
        db?.execSQL(dropNoteTableQuery)
        onCreate(db)
    }

}