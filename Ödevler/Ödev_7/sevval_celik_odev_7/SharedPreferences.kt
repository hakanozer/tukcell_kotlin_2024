package com.example.odev7

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson

class SharedPreferencesManager(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun getUser(): User? {
        val json = sharedPreferences.getString("user", null)
        return gson.fromJson(json, User::class.java)
    }

    fun setUser(user: User) {
        val json = gson.toJson(user)
        sharedPreferences.edit().putString("user", json).apply()
    }
}
