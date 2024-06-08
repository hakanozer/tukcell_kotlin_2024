package com.tlh.foods.roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tlh.foods.model.Food

@Dao
interface FoodDAO {

    //Data Access Object

    @Insert
    suspend fun insertAll(vararg food: Food): List<Long>

    @Query("SELECT * FROM food")
    suspend fun getAllFood(): List<Food>

    @Query("SELECT * FROM food WHERE uuid = :besinId")
    suspend fun getFood(besinId: Int): Food

    @Query("DELETE FROM food")
    suspend fun deleteAllFood()

}