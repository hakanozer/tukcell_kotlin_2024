package com.selincengiz.servisders

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson

class SharedStorage(context: Context) {
    val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("LocalStorage", Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = sharedPreferences.edit()
    val gson: Gson = Gson()

    inline fun <reified T> getObject(key: String): T? {
        val json = sharedPreferences.getString(key, null)
        return json?.let {
            gson.fromJson(it, T::class.java)
        }
    }

    fun <T> setObject(obj: T, key: String) {
        val json = gson.toJson(obj)
        editor.putString(key, json).commit()
    }

}