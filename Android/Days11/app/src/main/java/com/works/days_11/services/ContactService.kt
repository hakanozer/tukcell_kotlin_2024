package com.works.days_11.services

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.works.days_11.configs.DB
import com.works.days_11.models.Contact
import java.lang.StringBuilder

class ContactService(context: Context) : DB(context) {


    fun addContanct( name:String, surname: String, age: Int, color: String ) : Long {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put("name", name)
        values.put("surname", surname)
        values.put("age", age)
        values.put("color", color)

        val effectRow = db.insert("contacts", null, values)
        db.close()
        return effectRow
    }

    fun deleteContanct(cid: Int) : Int {
        val db = this.writableDatabase
        val deleteStatus = db.delete("contacts", "cid = $cid", null)
        //val deleteStatus = db.delete("contacts", "name = ?, surname = ?", arrayOf("ali", "bilmem"))
        db.close()
        return deleteStatus
    }

    fun updateContanct( name:String, surname: String, age: Int, color: String, cid: Int ) : Int {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put("name", name)
        values.put("surname", surname)
        values.put("age", age)
        values.put("color", color)

        val status = db.update("contacts", values, "cid = $cid", null )
        db.close()
        return status

    }


    fun allContanct() : List<Contact> {
        val db = this.readableDatabase
        val arr = mutableListOf<Contact>()
        //val cursor1 = db.query("contacts", null, null, null, null, null, null)
        val cursor = db.rawQuery("SelecT * from contacts", null)
        while (cursor.moveToNext()) {
            val cid = cursor.getInt(cursor.getColumnIndexOrThrow("cid"))
            val name = cursor.getString(1)
            val surname = cursor.getString(2)
            val age = cursor.getInt(3)
            val color = cursor.getString(4)
            val c = Contact(cid, name, surname, age, color)
            arr.add(c)
        }
        return arr
    }

    fun searchContanct(q: String) : List<Contact> {
        val db = this.readableDatabase
        val arr = mutableListOf<Contact>()
        //val cursor1 = db.query("contacts", null, null, null, null, null, null)
        val cursor = db.rawQuery("SelecT * from contacts where name like '%$q%' or surname like '%$q%'", null)
        while (cursor.moveToNext()) {
            val cid = cursor.getInt(cursor.getColumnIndexOrThrow("cid"))
            val name = cursor.getString(1)
            val surname = cursor.getString(2)
            val age = cursor.getInt(3)
            val color = cursor.getString(4)
            val c = Contact(cid, name, surname, age, color)
            arr.add(c)
        }
        return arr
    }

    fun singleContanct(name: String, surname: String) : Contact? {
        val db = this.readableDatabase
        val cursor = db.rawQuery("select * from contacts where name = ? and surname = ?", arrayOf(name, surname))
        if (cursor.moveToNext()) {
            val cid = cursor.getInt(cursor.getColumnIndexOrThrow("cid"))
            val name = cursor.getString(1)
            val surname = cursor.getString(2)
            val age = cursor.getInt(3)
            val color = cursor.getString(4)
            val c = Contact(cid, name, surname, age, color)
            db.close()
            return c
        }
        db.close()
        return null
    }


}