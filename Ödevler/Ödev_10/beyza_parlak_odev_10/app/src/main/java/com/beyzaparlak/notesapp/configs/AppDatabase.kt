package com.beyzaparlak.notesapp.configs

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.beyzaparlak.notesapp.dao.NotesDao
import com.beyzaparlak.notesapp.dao.UsersDao
import com.beyzaparlak.notesapp.entities.Note
import com.beyzaparlak.notesapp.entities.User

@Database(entities = [Note::class, User::class], version = 3)
abstract class AppDatabase : RoomDatabase(){

    abstract fun NotesDao(): NotesDao

    abstract fun UsersDao(): UsersDao
    /*// database de yapılan yenilikler dolayısıyla version güncelleme işlemine gidildi
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "pro1"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
        fun createDatabase(context: Context): AppDatabase {
            // Veritabanını sil
            context.deleteDatabase("pro1")

            // Yeni veritabanını oluştur
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, "pro1"
            ).fallbackToDestructiveMigration()
                .build()
        }
    }
    */
}

