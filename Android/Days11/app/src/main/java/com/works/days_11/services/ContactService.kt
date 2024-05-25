package com.works.days_11.services

import android.content.ContentValues
import android.content.Context
import com.works.days_11.configs.DB

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


}