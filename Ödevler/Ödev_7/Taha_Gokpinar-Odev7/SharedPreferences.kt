package com.works.days_8.configs
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.works.days_8.models.User

class SharedPreferences (context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("user_preferences", Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = sharedPreferences.edit()

    fun setUser(user: User){
        val gson = Gson()
        val userJson = gson.toJson(user)
        editor.putString("user", userJson)
        editor.commit()
    }

    fun getUser(): User? {
        val gson = Gson()
        val userJson = sharedPreferences.getString("user", null)
        return gson.fromJson(userJson, User::class.java)
    }

}