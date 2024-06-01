package com.example.yusuf_mucahit_solmaz_odev_10.db.service

import android.content.ContentValues
import android.content.Context
import com.example.yusuf_mucahit_solmaz_odev_10.db.connection.DBUser
import com.example.yusuf_mucahit_solmaz_odev_10.db.entitiy.UserDao


class UserService(context:Context): DBUser(context) {

    fun addUser(name:String,password:String):Long{

        val db=this.writableDatabase
        val values=ContentValues()
        values.put("name",name)
        values.put("password",password)

        val effectedRow=db.insert("users",null,values)
        db.close()

        return effectedRow

    }
    fun matchUser(name:String,password: String): UserDao?{
        val db=this.readableDatabase
        val cursor=db.rawQuery("SELECT * FROM users WHERE name=? and password=?", arrayOf(name,password))

        if(cursor.moveToNext()){
            val id=cursor.getInt(0)
            val name=cursor.getString(1)
            val password=cursor.getString(2)
            val userDao= UserDao(id,name,password)
            db.close()

            return userDao
        }
        db.close()
        return null

    }
}