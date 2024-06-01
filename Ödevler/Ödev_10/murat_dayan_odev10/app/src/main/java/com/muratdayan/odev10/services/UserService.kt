package com.muratdayan.odev10.services

import android.content.ContentValues
import android.content.Context
import com.muratdayan.odev10.configs.NotesDB
import com.muratdayan.odev10.models.User

class UserService(context: Context) : NotesDB(context) {


    companion object {
        const val TABLE_NAME = "user"
    }

    // Kullanıcı ekleme
    fun addUser(username:String,password:String): Long{

        val db = this.writableDatabase

        val values = ContentValues()
        values.put("username",username)
        values.put("password",password)

        val addQuery = db.insert(TABLE_NAME,null,values)
        db.close()
        return addQuery
    }

    // Kullanıcı adı kontrol
    fun controlUserNameAvailability(username:String) : Boolean{

        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT 1 FROM $TABLE_NAME WHERE username = ?", arrayOf(username))

        val isAvailable = cursor.moveToFirst() // Eğer cursor bir sonuç döndürürse, kullanıcı adı mevcut demektir

        cursor.close()
        db.close()
        return isAvailable
    }

    // Kullanıcı adı ve şifre kontrol ve döndürülmesi
    fun getUser(username:String,password:String): User?{
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME WHERE username = ? AND password = ?", arrayOf(username,password))
        var user:User? = null
        if(cursor.moveToFirst()){
            user = User(cursor.getInt(0),cursor.getString(1),cursor.getString(2))
        }
        cursor.close()
        db.close()
        return user
    }

}