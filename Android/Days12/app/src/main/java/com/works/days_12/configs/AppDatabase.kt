package com.works.days_12.configs

import androidx.room.Database
import androidx.room.RoomDatabase
import com.works.days_12.dao.ProductDao
import com.works.days_12.entitites.Product

@Database(entities = [Product::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun productDao()  : ProductDao

}