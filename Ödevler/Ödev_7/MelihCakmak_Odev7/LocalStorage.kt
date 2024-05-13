package com.example.sharedpreferencesapp.services

import android.content.Context
import com.example.sharedpreferencesapp.models.User
import com.google.gson.Gson

class LocalStorage(val context:Context) {
    private val sharedPreferences = context.getSharedPreferences("UserInfo", Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()
    private val gson = Gson()

    fun getUser():User?{
        val jsonUser = sharedPreferences.getString("user", null)
        if (jsonUser==null)
            return null
        val userObject:User=gson.fromJson(jsonUser,User::class.java)
        return  userObject

    }

    fun setUser(user:User){

        val jsonUser = gson.toJson(user)
        editor.putString("user", jsonUser)
        editor.commit()


    }

}