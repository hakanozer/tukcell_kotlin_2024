package com.example.odev

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson

class SharedPreferencesClass(private val context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun getUser(): User? {
        val jsonUser = sharedPreferences.getString("user", null)
        return if (jsonUser != null) {
            gson.fromJson(jsonUser, User::class.java)
        } else {
            null
        }
    }

    fun setUser(user: User?) {
        val jsonUser = gson.toJson(user)
        sharedPreferences.edit().putString("user", jsonUser).apply()
    }

}

data class User(val id: Int, val name: String, val email: String)
