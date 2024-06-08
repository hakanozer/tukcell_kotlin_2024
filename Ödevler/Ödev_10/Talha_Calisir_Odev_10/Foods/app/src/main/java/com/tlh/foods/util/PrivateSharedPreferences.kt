package com.tlh.foods.util

import android.content.Context
import android.content.SharedPreferences

class PrivateSharedPreferences {

    companion object {

        private val TIME = "time"
        private var sharedPreferences : SharedPreferences? = null

        @Volatile private var instance : PrivateSharedPreferences? = null
        private val lock = Any()

        operator fun invoke(context: Context) : PrivateSharedPreferences = instance ?: synchronized(lock) {
            instance ?: doPrivateSharedPreferences(context).also {
                instance = it
            }
        }

        private fun doPrivateSharedPreferences(context: Context): PrivateSharedPreferences{
            sharedPreferences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(context)
            return PrivateSharedPreferences()
        }
    }

    fun saveTheTime(zaman: Long){
        sharedPreferences?.edit()?.putLong(TIME,zaman)?.apply()
    }

    fun takeTheTime() = sharedPreferences?.getLong(TIME,0)

}