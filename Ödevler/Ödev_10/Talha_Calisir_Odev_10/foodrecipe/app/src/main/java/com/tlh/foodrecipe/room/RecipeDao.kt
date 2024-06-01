package com.tlh.foodrecipe.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.tlh.foodrecipe.model.Recipe
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
interface RecipeDao {

    @Query("SELECT * FROM Recipe")
    fun getAll(): Flowable<List<Recipe>>

    @Query("SELECT * FROM Recipe WHERE rid = :rid")
    fun getById(rid: Int): Flowable<Recipe> // if returns something, use Flowable

    @Insert
    fun insert(recipe: Recipe): Completable // if doesnt return anything, use Completable

    @Delete
    fun delete(recipe: Recipe) : Completable
}