//veri tabanı üzerinden hizmet verebilmesi için hizmetlerimizi oluşturuyoruz
//yönetilebilir olması açısından UserService ve NoteService olarak servisleri böldük

package com.umutyusufcinar.odev10.services

import android.content.ContentValues
import android.content.Context
import com.umutyusufcinar.odev10.configs.DB
import com.umutyusufcinar.odev10.models.Note

class NoteService(context: Context) : DB(context) {

    //not ekleyen fonksiyon
    fun addNote(uid: Int, title: String, content: String, date: String): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put(COLUMN_USER_ID_FK, uid)
            put(COLUMN_NOTE_TITLE, title)
            put(COLUMN_NOTE_CONTENT, content)
            put(COLUMN_NOTE_DATE, date )
        }
        val effectRow = db.insert(TABLE_NOTES, null, contentValues)
        db.close()
        return effectRow
    }

    //kullanıcının notlarını getiren fonksiyon
    fun getNotesForUser(uid: Int): MutableList<Note> {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NOTES WHERE $COLUMN_USER_ID_FK = ?", arrayOf(uid.toString()))
        val notes = mutableListOf<Note>()
        while (cursor.moveToNext()) {
            val note = Note(
                cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_NOTE_ID)),
                cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_USER_ID_FK)),
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NOTE_TITLE)),
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NOTE_CONTENT)),
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NOTE_DATE))
            )
            notes.add(note)
        }
        cursor.close()
        db.close()
        return notes
    }
    //note id sine göre getiren fonksiyon
    fun getNoteById(nid: Int): Note? {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NOTES WHERE $COLUMN_NOTE_ID = ?", arrayOf(nid.toString()))
        val note = if (cursor.moveToNext()) {
            Note(
                cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_NOTE_ID)),
                cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_USER_ID_FK)),
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NOTE_TITLE)),
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NOTE_CONTENT)),
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NOTE_DATE))
            )
        } else {
            null
        }
        cursor.close()
        db.close()
        return note
    }

    //id ye göre not güncelleyen fonksiyon
    fun updateNoteById(nid: Int, title: String, date: String, content: String): Int {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NOTE_TITLE, title)
            put(COLUMN_NOTE_DATE, date)
            put(COLUMN_NOTE_CONTENT, content)
        }
        val updateStatus = db.update(TABLE_NOTES, values, "$COLUMN_NOTE_ID = ?", arrayOf(nid.toString()))
        db.close()
        return updateStatus
    }

    //id ye göre not silen fonksiyon
    fun deleteNoteById(nid: Int): Int {
        val db = this.writableDatabase
        val deleteStatus = db.delete(TABLE_NOTES, "$COLUMN_NOTE_ID = ?", arrayOf(nid.toString()))
        db.close()
        return deleteStatus
    }

    //kullanıcının tüm notlarını silen fonksiyon
    fun deleteAllNotesForUser(uid: Int): Int {
        val db = this.writableDatabase
        val deleteStatus = db.delete(TABLE_NOTES, "$COLUMN_USER_ID_FK = ?", arrayOf(uid.toString()))
        db.close()
        return deleteStatus
    }

    //not araması yapan fonksiyon
    fun searchNotes(q: String, uid: Int): MutableList<Note> {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NOTES WHERE $COLUMN_USER_ID_FK = ? AND " +
                "($COLUMN_NOTE_TITLE LIKE ? OR $COLUMN_NOTE_CONTENT LIKE ?)",
            arrayOf(uid.toString(), "%$q%", "%$q%"))
        val notes = mutableListOf<Note>()
        while (cursor.moveToNext()) {
            val note = Note(
                cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_NOTE_ID)),
                cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_USER_ID_FK)),
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NOTE_TITLE)),
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NOTE_CONTENT)),
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NOTE_DATE))
            )
            notes.add(note)
        }
        cursor.close()
        db.close()
        return notes
    }
}