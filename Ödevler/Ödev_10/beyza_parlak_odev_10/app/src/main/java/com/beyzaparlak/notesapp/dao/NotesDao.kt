package com.beyzaparlak.notesapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.beyzaparlak.notesapp.entities.Note

@Dao
interface NotesDao {

    // return id döndürür
    @Insert
    fun insert(note: Note) : Long

    // not silme işlemi
    @Delete
    fun delete(note: Note) : Int

    // not güncelleme işlemi
    @Update
    fun update(note: Note) : Int

    // tüm notları getirir
    @Query("SELECT * FROM notes")
    fun getAll(): List<Note>

    // id ye göre filtreleme
    @Query("SELECT * FROM notes WHERE nid =:nid")
    fun findById(nid:Int): Note?

    // title a göre filtreleme
    @Query("SELECT * FROM notes WHERE title like :title")
    fun searchTitle(title: String): List<Note>

    // detail e göre filtreleme
    @Query("SELECT * FROM notes WHERE detail like :detail")
    fun searchDetail(detail: String): List<Note>

    // title ve detail e göre filtreleme
    @Query("SELECT * FROM notes WHERE title LIKE :query OR detail LIKE :query")
    fun searchByTitleOrDetail(query: String): List<Note>

}