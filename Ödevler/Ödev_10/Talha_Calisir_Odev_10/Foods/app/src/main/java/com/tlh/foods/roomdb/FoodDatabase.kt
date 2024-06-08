package com.tlh.foods.roomdb

import android.content.Context
import androidx.room.Database

import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.tlh.foods.model.Food

@Database(entities = [Food::class],version = 1)
abstract class FoodDatabase : RoomDatabase() {

    abstract fun foodDao(): FoodDAO

    //Singleton

    companion object {

        @Volatile
        private var instance: FoodDatabase? = null

        private val lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: databaseOlustur(context).also {
                instance = it
            }
        }


        private fun databaseOlustur(context: Context) = databaseBuilder(
            context.applicationContext,
            FoodDatabase::class.java, "fooddatabase"
        ).build()

    }
}