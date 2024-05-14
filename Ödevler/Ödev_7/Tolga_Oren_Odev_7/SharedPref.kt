package com.toren.sharedpref

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson

class SharedPref(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = sharedPreferences.edit()

    companion object {
        private const val SHARED_PREF_NAME = "MySharedPref"
        private var instance: SharedPref? = null

        @Synchronized //singleton olması için classı buradan çağırıyoruz (SharedPref.getInstance(context))
        fun getInstance(context: Context): SharedPref {
            if (instance == null) {
                instance = SharedPref(context)
            }
            return instance!!
        }
    }

    fun saveUser(key: String, value: User) {
        val gson = Gson().toJson(value)
        editor.putString(key, gson)
        editor.commit()
    }

    fun getUser(key: String): User? {
        val gson = sharedPreferences.getString(key, null)
        return Gson().fromJson(gson, User::class.java)
    }
}