package com.aliberkaygedikoglu.odev10.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aliberkaygedikoglu.odev10.entity.User
import com.aliberkaygedikoglu.odev10.entity.UserNote

@Database(entities = [User::class, UserNote::class], version = 2)
abstract class DB : RoomDatabase(){
    abstract fun userNoteDao(): UserNotesDao
    abstract fun usersDao(): UsersDao

    companion object {
        private var instance: DB? = null

        fun getDatabase(context: Context): DB? {

            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    DB::class.java,
                    "odev.db"
                ).allowMainThreadQueries().fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }

}