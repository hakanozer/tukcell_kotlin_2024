package com.canerdedeoglu.odev10.services

import android.content.ContentValues
import android.content.Context
import com.canerdedeoglu.odev10.configs.DB
import com.canerdedeoglu.odev10.models.Notes

class NoteService(context: Context) : DB(context) {

    fun addNote(title : String, description : String, date : String, category : String, userId: Int) : Long
    {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put("title", title)
        values.put("description", description)
        values.put("date", date)
        values.put("category", category)
        values.put("userId", userId)

        val effectRow = db.insert("Notes", null, values)
        //db.close()
        return effectRow
    }

    fun deleteNote(noteId : Int) : Int
    {
        val db = this.writableDatabase
        val effectRow = db.delete("Notes", "noteId = ?", arrayOf(noteId.toString()))
        //db.close()
        return effectRow
    }

    fun updateNote(noteId : Int, title : String, description : String, date : String, category : String, userId: Int) : Int
    {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put("title", title)
        values.put("description", description)
        values.put("date", date)
        values.put("category", category)
        values.put("userId", userId)

        val effectRow = db.update("Notes", values, "noteId = ?", arrayOf(noteId.toString()))
        //db.close()
        return effectRow
    }

    fun getAllNotes(userId: Int): List<Notes> {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM Notes WHERE userId = ?", arrayOf(userId.toString()))
        val notesList = ArrayList<Notes>()

        if (cursor.moveToFirst()) {
            do {
                val noteId = cursor.getInt(cursor.getColumnIndexOrThrow("noteId"))
                val title = cursor.getString(cursor.getColumnIndexOrThrow("title"))
                val description = cursor.getString(cursor.getColumnIndexOrThrow("description"))
                val date = cursor.getString(cursor.getColumnIndexOrThrow("date"))
                val category = cursor.getString(cursor.getColumnIndexOrThrow("category"))
                val user_id = cursor.getInt(cursor.getColumnIndexOrThrow("userId"))
                notesList.add(Notes(noteId, title, description, date, category, user_id))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()

        return notesList
    }



    fun getNotesByCategoryAndTitle(identifier: String): MutableList<Notes> {
        val db = this.readableDatabase
        val notes = mutableListOf<Notes>()

        val cursor = db.rawQuery(
            "SELECT * FROM Notes WHERE title LIKE ? OR category LIKE ?", arrayOf("%$identifier%", "%$identifier%")
        )

        if (cursor.moveToFirst()) {
            val noteId = cursor.getInt(cursor.getColumnIndexOrThrow("noteId"))
            val noteTitle = cursor.getString(cursor.getColumnIndexOrThrow("title"))
            val description = cursor.getString(cursor.getColumnIndexOrThrow("description"))
            val date = cursor.getString(cursor.getColumnIndexOrThrow("date"))
            val noteCategory = cursor.getString(cursor.getColumnIndexOrThrow("category"))
            val userId = cursor.getInt(cursor.getColumnIndexOrThrow("userId"))

            val note = Notes(noteId, noteTitle, description, date, noteCategory, userId)
            notes.add(note)
        }
        cursor.close()
        // db.close()
        return notes
    }



}