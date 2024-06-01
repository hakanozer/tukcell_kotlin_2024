package com.muratdayan.odev10.services

import android.content.ContentValues
import android.content.Context
import com.muratdayan.odev10.configs.NotesDB
import com.muratdayan.odev10.models.Note

class NoteService(context: Context) : NotesDB(context) {

    companion object {
        const val TABLE_NAME = "note"
    }

    // not ekleme
    fun addNote(title:String,detail:String,priority:Int,date:String,isDone:Int): Long{

        val db = this.writableDatabase

        val values = ContentValues()
        values.put("title",title)
        values.put("detail",detail)
        values.put("priority",priority)
        values.put("date",date)
        values.put("isDone",isDone)

        val insertStatus = db.insert(TABLE_NAME,null,values)
        db.close()
        return insertStatus
    }

    // notları silme
    fun deleteNote(vararg nids:Int) : Int {
        var deletedCount = 0
        val db = this.writableDatabase
        ///val deleteStatus = db.delete(TABLE_NAME, "nid = $nid", null)
        for (nid in nids){
            val deleteStatus = db.delete(TABLE_NAME, "nid = ?", arrayOf(nid.toString()))
            deletedCount += deleteStatus

        }

        db.close()
        return deletedCount
    }

    // not güncelleme
    fun updateNote( nid:Int, title:String, detail:String, priority:Int, date:String, isDone:Int ) : Int {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put("title",title)
        values.put("detail",detail)
        values.put("priority",priority)
        values.put("date",date)
        values.put("isDone",isDone)

        val updateStatus = db.update(TABLE_NAME, values, "nid = ?", arrayOf(nid.toString()) )
        db.close()
        return updateStatus

    }

    // tüm notları getirir
    fun getAllNotes(): List<Note> {
        val db = this.readableDatabase
        val notes = mutableListOf<Note>()

        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        cursor.use { // Use cursor in a safe block to ensure proper closing
            while (it.moveToNext()) {
                val nid = it.getInt(it.getColumnIndexOrThrow("nid"))
                val title = it.getString(it.getColumnIndexOrThrow("title"))
                val detail = it.getString(it.getColumnIndexOrThrow("detail"))
                val priority = it.getInt(it.getColumnIndexOrThrow("priority"))
                val date = it.getString(it.getColumnIndexOrThrow("date"))
                val isDone = it.getInt(it.getColumnIndexOrThrow("isDone"))
                val note = Note(nid, title, detail, priority, date, isDone)
                notes.add(note)
            }
        }
        return notes
    }

    // q stringine göre title columnundan arama yapar
    fun searchNotes(q: String) : List<Note> {
        val db = this.readableDatabase
        val arr = mutableListOf<Note>()
        //val cursor1 = db.query("contacts", null, null, null, null, null, null)
        val cursor = db.rawQuery("SelecT * from $TABLE_NAME where title like '%$q%'", null)
        while (cursor.moveToNext()) {
            val nid = cursor.getInt(cursor.getColumnIndexOrThrow("nid"))
            val title = cursor.getString(1)
            val detail = cursor.getString(2)
            val priority = cursor.getInt(3)
            val date = cursor.getString(4)
            val isDone = cursor.getInt(5)
            val n = Note(nid,title,detail,priority,date,isDone)
            arr.add(n)
        }
        cursor.close()
        db.close()
        return arr
    }

    // priority değerine göre sıralı liste döndürür
    fun getNotesSortedByPriority(): List<Note> {
        val db = this.readableDatabase
        val notes = mutableListOf<Note>()
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME ORDER BY priority ASC", null)

        cursor.use {
            while (it.moveToNext()) {
                val nid = it.getInt(it.getColumnIndexOrThrow("nid"))
                val title = it.getString(it.getColumnIndexOrThrow("title"))
                val detail = it.getString(it.getColumnIndexOrThrow("detail"))
                val priority = it.getInt(it.getColumnIndexOrThrow("priority"))
                val date = it.getString(it.getColumnIndexOrThrow("date"))
                val isDone = it.getInt(it.getColumnIndexOrThrow("isDone"))
                val note = Note(nid, title, detail, priority, date, isDone)
                notes.add(note)
            }
        }

        return notes
    }

}