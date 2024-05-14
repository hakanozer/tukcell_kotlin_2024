package com.emrecura.days_9.shared_pref

import android.content.Context
import android.content.SharedPreferences
import com.emrecura.days_9.models.User
import com.google.gson.Gson

class UserPreferences(context: Context) {
    private val PREF_NAME = "UserPreferences"
    private val KEY_USER = "user"
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    private val gson = Gson()

    fun getUser(): User? {
        val json = sharedPreferences.getString(KEY_USER, null)
        return gson.fromJson(json, User::class.java)
    }

    fun setUser(user: User) {
        val json = gson.toJson(user)
        sharedPreferences.edit().putString(KEY_USER, json).apply()
    }
}