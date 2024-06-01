package com.cevdetkilickeser.odev_11.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cevdetkilickeser.odev_11.dao.NoteDao
import com.cevdetkilickeser.odev_11.dao.UserDao
import com.cevdetkilickeser.odev_11.entity.Notte
import com.cevdetkilickeser.odev_11.entity.User
import com.cevdetkilickeser.odev_11.utils.DATABASE_NAME

@Database(entities = [Notte::class, User::class],version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getNoteDao() : NoteDao
    abstract fun getUserDao() : UserDao

    companion object{
        @Volatile
        private var INSTANCE : AppDatabase? = null

        fun getDatabase(context: Context) : AppDatabase{
            return  INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NAME
                ).build()

                INSTANCE = instance

                instance
            }
        }
    }
}