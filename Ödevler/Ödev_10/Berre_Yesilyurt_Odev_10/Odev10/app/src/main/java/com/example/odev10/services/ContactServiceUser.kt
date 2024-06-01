package com.example.odev10.services

import android.content.ContentValues
import android.content.Context
import com.example.odev10.configs.DBUser
import com.example.odev10.models.User

class ContactServiceUser(context:Context):DBUser(context) {

    fun addUser(name:String,password:String):Long{ // Kullanıcı ekleme

        val db=this.writableDatabase
        val values=ContentValues()
        values.put("name",name)
        values.put("password",password)

        val effectedRow=db.insert("users",null,values)
        db.close()

        return effectedRow

    }

    fun deleteUser(id:Int):Int{ // Kullanıcı silme
        val db=this.writableDatabase
        val deleteStatus=db.delete("users","id=$id",null)
        db.close()
        return  deleteStatus
    }

    fun listUsers():List<User>{ // Kullanıcıları listeleme
        val db=this.readableDatabase
        val userList= mutableListOf<User>()
        val cursor=db.rawQuery("SELECT * FROM users",null)

        while (cursor.moveToNext()){
            val id=cursor.getInt(0)
            val name=cursor.getString(1)
            val password=cursor.getString(2)
            val user=User(id,name,password)

            userList.add(user)
        }
        return userList
    }

    fun matchUser(name:String,password: String):User?{ // Giriş sayfasında kullanıcı adının eşleşip eşleşmediğinin kontrolü
        val db=this.readableDatabase
        val cursor=db.rawQuery("SELECT * FROM users WHERE name=? and password=?", arrayOf(name,password))

        if(cursor.moveToNext()){
            val id=cursor.getInt(0)
            val name=cursor.getString(1)
            val password=cursor.getString(2)
            val user=User(id,name,password)
            db.close()

            return user
        }
        db.close()
        return null

    }
}