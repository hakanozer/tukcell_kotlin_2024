package com.example.odev10.services

import android.content.ContentValues
import android.content.Context
import com.example.odev10.configs.DBNotes
import com.example.odev10.models.Notes

class ContactServiceNotes(context:Context):DBNotes(context) {

    fun addNote(lessonName:String,note:Int):Long{
        val db=this.writableDatabase
        val values=ContentValues()
        values.put("lessonName",lessonName)
        values.put("note",note)

        val effectedRow=db.insert("notes",null,values)
        db.close()

        return effectedRow
    }

    fun deleteNote(id:Int):Int{ // Kullanıcı silme
        val db=this.writableDatabase
        val deleteStatus=db.delete("notes","id=$id",null)
        db.close()
        return  deleteStatus
    }

    fun updateNotes(id:Int,lessonName:String,note:Int):Int{
        val db=this.writableDatabase
        val values=ContentValues()

        values.put("id",id)
        values.put("lessonName",lessonName)
        values.put("note",note)

        val status=db.update("notes",values,"id=$id",null)
        db.close()
        return status

    }

    fun listNotes():List<Notes>{
        val db=this.readableDatabase

        val notesList= mutableListOf<Notes>()
        val cursor=db.rawQuery("SELECT * FROM notes",null)

        while(cursor.moveToNext()){
            val id=cursor.getInt(0)
            val lessonName=cursor.getString(1)
            val note=cursor.getInt(2)
            val notes=Notes(id,lessonName,note)
            notesList.add(notes)
        }

        return notesList
    }

    fun searchNotes(q:String):List<Notes>{
        val db=this.readableDatabase
        val arr= mutableListOf<Notes>()

        val cursor=db.rawQuery("SELECT * FROM notes WHERE lessonName like '%$q%' ",null)

        while(cursor.moveToNext()){
            val id=cursor.getInt(0)
            val lessonName=cursor.getString(1)
            val note=cursor.getInt(2)

            val oneNote=Notes(id,lessonName,note)
            arr.add(oneNote)
        }

        return arr

    }
}