package com.canerdedeoglu.days_8
import android.content.SharedPreferences
import android.content.Context
import com.canerdedeoglu.days_8.models.User
import com.google.gson.Gson

class SharedPreferences (context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("user_preference", Context.MODE_PRIVATE)
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