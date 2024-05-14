package com.cevdetkilickeser.days8

import android.content.Context
import android.util.Log
import com.cevdetkilickeser.days8.models.User
import com.google.gson.Gson

class BaseShared(context: Context) {

    val shared = context.getSharedPreferences("shared", Context.MODE_PRIVATE)
    val editor = shared.edit()


    fun getUser(key: String): User {
        val gson = Gson()
        val stUser = shared.getString(key, null)

        return gson.fromJson(stUser, User::class.java)
    }


    fun setUSer(key: String, user: User) {
        val gson = Gson()
        val stUser = gson.toJson(user)

        editor.putString(key, stUser)
        editor.commit()
    }
}