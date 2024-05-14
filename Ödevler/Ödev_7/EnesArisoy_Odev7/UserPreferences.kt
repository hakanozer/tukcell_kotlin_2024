package com.ns.enesarisoy_odev7

import android.content.Context
import com.google.gson.Gson

class UserPreferences(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("user_pref", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun saveUser(user: User) {
        sharedPreferences.edit().putString("user", gson.toJson(user)).apply()
    }

    fun getUser(): User? {
        val userJson = sharedPreferences.getString("user", null)
        return gson.fromJson(userJson, User::class.java)
    }

    fun deleteUser() {
        sharedPreferences.edit().remove("user").apply()
    }
}