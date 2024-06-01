package com.bengisusahin.odev_10.configs

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

//Context parameter is used to access specific resources and services of the application
open class DB(private val context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){
    // companion object is used to define Singleton object within a class
    // Singleton ensure that only one instance(object)of the class is created
    // This object can be accessed directly without creating object of class
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

    // called when the database is created for the first time
    override fun onCreate(db: SQLiteDatabase?) {
        // primary key is a concept of SQL that uniquely identifies each item in a db table
        val createUserTableQuery = "CREATE TABLE $TABLE_USERS (" +
                "$COLUMN_USER_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_USERNAME TEXT, " +
                "$COLUMN_PASSWORD TEXT)"
        db?.execSQL(createUserTableQuery)

        // FK(foreign key) is a column or a set of columns in a table that references the primary key of another table
        val createNotesTableQuery = "CREATE TABLE $TABLE_NOTES (" +
                "$COLUMN_NOTE_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_USER_ID_FK INTEGER, " +
                "$COLUMN_NOTE_TITLE TEXT, " +
                "$COLUMN_NOTE_CONTENT TEXT," +
                "$COLUMN_NOTE_DATE TEXT, " +
                "FOREIGN KEY($COLUMN_USER_ID_FK) REFERENCES $TABLE_USERS($COLUMN_USER_ID))"
        db?.execSQL(createNotesTableQuery)
    }

    // called when the database needs to be upgraded when the db version number is increased
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val dropUserTableQuery = "DROP TABLE IF EXISTS $TABLE_USERS"
        val dropNoteTableQuery = "DROP TABLE IF EXISTS $TABLE_NOTES"
        db?.execSQL(dropUserTableQuery)
        db?.execSQL(dropNoteTableQuery)
        onCreate(db)
    }

}