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


}