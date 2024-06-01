package com.aliberkaygedikoglu.odev10.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.aliberkaygedikoglu.odev10.entity.UserNote

@Dao
interface UserNotesDao {
    @Insert
    fun insert(userNote: UserNote) : Long

    @Delete
    fun delete(userNote: UserNote) : Int

    @Update
    fun update(userNote: UserNote) : Int

    @Query("SELECT * FROM notes WHERE :uid")
    fun getAll(uid:Int): List<UserNote>

    //name filtreleme
    @Query("SELECT * FROM notes WHERE name like '%' || :searchWord || '%'")
    fun searchName(searchWord: String): List<UserNote>

}