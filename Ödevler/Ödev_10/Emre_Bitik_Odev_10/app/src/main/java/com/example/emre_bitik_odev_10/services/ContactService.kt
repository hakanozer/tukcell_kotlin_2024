package com.example.emre_bitik_odev_10.services

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.example.emre_bitik_odev_10.configs.DB
import com.example.emre_bitik_odev_10.models.Note
import com.example.emre_bitik_odev_10.models.User
import java.lang.StringBuilder


class ContactService(context: Context) : DB(context) {
    fun addContact(title: String, detail: String): Long {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put("title", title)
        values.put("detail", detail)
        val effectRow = db.insert("notes", null, values)
        db.close()
        return effectRow
    }
 fun addUSer(username: String, password: String): Long {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put("username", username)
        values.put("password", password)
        val effectRow = db.insert("users", null, values)
        db.close()
        return effectRow
    }

    fun deleteContact(cid : Int):Int{
        val db = this.writableDatabase
        val deleteStatus = db.delete("notes","cid = $cid",null)
        return deleteStatus
    }

    fun updateContact(title: String, detail: String,cid: Int):Int{
        val db = this.writableDatabase
        val values = ContentValues()
        values.put("title", title)
        values.put("detail", detail)

        val status = db.update("notes",values,"cid= $cid",null) // güncelleme
        db.close()
        return status
    }

    fun allContanct():List<Note>{
        val db = this.readableDatabase
        val arr = mutableListOf<Note>()
        val cursor = db.rawQuery("Select * from notes",null)
        while (cursor.moveToNext()){

            val cid = cursor.getInt(cursor.getColumnIndexOrThrow("cid"))
            val title =cursor.getString(1)
            val detail =cursor.getString(2)


            val c = Note(cid,title,detail)
            arr.add(c)

        }

        return arr
    }

    fun searchContanct(q:String):List<Note>{
        val db = this.readableDatabase
        val arr = mutableListOf<Note>()
        val cursor = db.rawQuery("SelecT * from notes where title like '%$q%'or detail like'%$q%'",null)
        while (cursor.moveToNext()){

            val cid = cursor.getInt(cursor.getColumnIndexOrThrow("cid"))
            val title =cursor.getString(1)
            val detail =cursor.getString(2)

            val c = Note(cid,title,detail)
            arr.add(c)

        }

        return arr
    }

    fun singleContanct(title: String,detail: String): Note?{
        val db = this.readableDatabase
        val cursor = db.rawQuery("select * from notes where title= '$title' and detail='$detail'",null)
        if (cursor.moveToNext()){

            val cid = cursor.getInt(cursor.getColumnIndexOrThrow("cid"))
            val title =cursor.getString(1)
            val detail =cursor.getString(2)

            val c = Note(cid,title,detail)

            return c
        }
        db.close()
        cursor.close()
        return null
    }
    fun singleUser(username: String, password: String): User? {
        val db = this.readableDatabase
        val cursor = db.rawQuery("select * from users where username= '$username' and password='$password'", null)
        if (cursor.moveToNext()) {
            val cid = cursor.getInt(cursor.getColumnIndexOrThrow("cid"))
            val fetchedUsername = cursor.getString(1)
            val fetchedPassword = cursor.getString(2)
            val user = User(cid, fetchedUsername, fetchedPassword)
            db.close()
            cursor.close()
            return user
        }
        db.close()
        cursor.close()
        return null
    }

}