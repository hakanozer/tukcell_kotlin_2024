package com.mai.odev_7.SharedPreferences

import android.content.Context
import com.google.gson.Gson

class UserPreferences(context: Context) {
    private val sharedPreferences = context.getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun setUser(user: User) {
        val editor = sharedPreferences.edit()
        val userJson = gson.toJson(user)
        editor.putString("user", userJson)
        editor.apply()
    }

    fun getUser(): User? {
        val userJson = sharedPreferences.getString("user", null)
        return gson.fromJson(userJson, User::class.java)
    }
}