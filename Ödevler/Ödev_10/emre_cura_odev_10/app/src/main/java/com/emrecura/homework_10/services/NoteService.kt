package com.emrecura.homework_10.services

import android.content.ContentValues
import android.content.Context
import com.emrecura.homework_10.database.DB
import com.emrecura.homework_10.model.NoteModel

class NoteService(context: Context) : DB(context) {

    fun addNote( userId: Int, title:String, detail: String, date: String) : Long {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put("uid", userId)
        values.put("title", title)
        values.put("detail", detail)
        values.put("date", date)

        val effectRow = db.insert("note", null, values)
        db.close()
        return effectRow
    }

    fun deleteNote(nid: Int) : Int {
        val db = this.writableDatabase
        val status = db.delete("note", "nid = $nid", null )
        db.close()
        return status
    }


    fun allNote() : List<NoteModel> {
        val db = this.readableDatabase
        val arr = mutableListOf<NoteModel>()
        val cursor = db.query("note",null, null, null, null, null, null)
        while (cursor.moveToNext()) {
            val nid = cursor.getInt(0)
            val uid = cursor.getInt(1)
            val title = cursor.getString(2)
            val detail = cursor.getString(3)
            val date = cursor.getString(4)
            val note = NoteModel(nid, uid, title, detail, date)
            arr.add(note)
        }
        db.close()
        return arr
    }
    fun updateNote( title:String, detail: String, date: String, nid: Int ) : Int {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put("title", title)
        values.put("detail", detail)
        values.put("date", date)

        val status = db.update("note", values, "nid = $nid", null )
        db.close()
        return status

    }
    fun searchNote(q: String) : List<NoteModel> {
        val db = this.readableDatabase
        val arr = mutableListOf<NoteModel>()
        val cursor = db.rawQuery("Select * from note where title like '%$q%' or detail like '%$q%'", null)
        while (cursor.moveToNext()) {
            val nid = cursor.getInt(0)
            val uid = cursor.getInt(1)
            val title = cursor.getString(2)
            val detail = cursor.getString(3)
            val date = cursor.getString(4)
            val note = NoteModel(nid,uid, title, detail, date)
            arr.add(note)
        }
        cursor.close()
        db.close()
        return arr
    }
    fun getNotesByUserId(userId: Int): List<NoteModel> {
        val db = this.readableDatabase
        val arr = mutableListOf<NoteModel>()
        val cursor = db.query("note", null, "uid = ?", arrayOf(userId.toString()), null, null, null)
        while (cursor.moveToNext()) {
            val nid = cursor.getInt(cursor.getColumnIndexOrThrow("nid"))
            val uid = cursor.getInt(cursor.getColumnIndexOrThrow("uid"))
            val title = cursor.getString(cursor.getColumnIndexOrThrow("title"))
            val detail = cursor.getString(cursor.getColumnIndexOrThrow("detail"))
            val date = cursor.getString(cursor.getColumnIndexOrThrow("date"))
            val note = NoteModel(nid, uid, title, detail, date)
            arr.add(note)
        }
        cursor.close()
        db.close()
        return arr
    }
    fun getNoteById(nid: Int): NoteModel? {
        val db = this.readableDatabase
        var note: NoteModel? = null
        val cursor = db.query("note", null, "nid = ?", arrayOf(nid.toString()), null, null, null)
        if (cursor.moveToFirst()) {
            val uid = cursor.getInt(cursor.getColumnIndexOrThrow("uid"))
            val title = cursor.getString(cursor.getColumnIndexOrThrow("title"))
            val detail = cursor.getString(cursor.getColumnIndexOrThrow("detail"))
            val date = cursor.getString(cursor.getColumnIndexOrThrow("date"))
            note = NoteModel(nid, uid, title, detail, date)
        }
        cursor.close()
        db.close()
        return note
    }
}