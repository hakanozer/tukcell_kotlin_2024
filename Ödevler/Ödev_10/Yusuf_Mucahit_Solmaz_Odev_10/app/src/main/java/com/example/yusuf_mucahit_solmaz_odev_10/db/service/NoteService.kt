package com.example.yusuf_mucahit_solmaz_odev_10.db.service

import android.content.ContentValues
import android.content.Context
import com.example.yusuf_mucahit_solmaz_odev_10.db.connection.DBNote
import com.example.yusuf_mucahit_solmaz_odev_10.db.entitiy.NoteDao


class NoteService(context:Context): DBNote(context) {

    fun saveNote(noteTitle:String, note:String):Long{
        val db=this.writableDatabase
        val values=ContentValues()
        values.put("noteTitle",noteTitle)
        values.put("note",note)

        val effectedRow=db.insert("notes",null,values)
        db.close()

        return effectedRow
    }

    fun deleteNoteById(id:Int):Int{
        val db=this.writableDatabase
        val deleteStatus=db.delete("notes","id=$id",null)
        db.close()
        return  deleteStatus
    }

    fun updateNotes(id:Int,noteTitle:String,note:Int):Int{
        val db=this.writableDatabase
        val values=ContentValues()

        values.put("id",id)
        values.put("noteTitle",noteTitle)
        values.put("note",note)

        val status=db.update("notes",values,"id=$id",null)
        db.close()
        return status

    }

    fun listNotes():List<NoteDao>{
        val db=this.readableDatabase

        val noteDaoList= mutableListOf<NoteDao>()
        val cursor=db.rawQuery("SELECT * FROM notes",null)

        while(cursor.moveToNext()){
            val id=cursor.getInt(0)
            val lessonName=cursor.getString(1)
            val note=cursor.getString(2)
            val notes= NoteDao(id,lessonName,note)
            noteDaoList.add(notes)
        }

        return noteDaoList
    }

    fun searchNotes(q:String):List<NoteDao>{
        val db=this.readableDatabase
        val arr= mutableListOf<NoteDao>()

        val cursor=db.rawQuery("SELECT * FROM notes WHERE noteTitle like '%$q%' ",null)

        while(cursor.moveToNext()){
            val id=cursor.getInt(0)
            val lessonName=cursor.getString(1)
            val note=cursor.getString(2)

            val oneNoteDao= NoteDao(id,lessonName,note)
            arr.add(oneNoteDao)
        }

        return arr

    }
}