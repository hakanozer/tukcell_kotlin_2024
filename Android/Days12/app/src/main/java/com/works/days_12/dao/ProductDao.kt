package com.works.days_12.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.works.days_12.entitites.Product

@Dao
interface ProductDao {

    @Insert
    fun insert( product: Product ) : Long // return id

    @Delete
    fun delete( product: Product ) : Int

    @Update
    fun update( product: Product ) : Int

    @Query("select * from product")
    fun getAll() : List<Product>

    @Query("select * from product where pid = :pid")
    fun findById( pid: Int ) : Product?

    @Query("select * from product where title like :title")
    fun searhTitle (title: String) : List<Product>
}