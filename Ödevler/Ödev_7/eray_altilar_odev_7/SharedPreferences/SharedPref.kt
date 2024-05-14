package com.example.odev_7_study

import android.content.Context
import com.google.gson.Gson

class SharedPref(context: Context){
    private val sharedPreferences = context.getSharedPreferences("user" , Context.MODE_PRIVATE)
    val gson = Gson()

    fun setUser(user:User){
        val editor = sharedPreferences.edit()
        val json = gson.toJson(user)
        editor.putString("user" , json)
        editor.commit()
    }

    fun getuser():User?{
        val gtUser = sharedPreferences.getString("user" , null)
        return gson.fromJson(gtUser , User::class.java)
    }

}