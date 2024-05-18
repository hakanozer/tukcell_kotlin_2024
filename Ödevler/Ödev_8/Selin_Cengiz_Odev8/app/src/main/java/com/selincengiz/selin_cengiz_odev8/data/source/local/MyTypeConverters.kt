package com.selincengiz.selin_cengiz_odev8.data.source.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MyTypeConverters {
    @TypeConverter
    fun fromListToJSON(list: List<String>): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun fromJSONToList(json: String): List<String> {
        return Gson().fromJson(json, object : TypeToken<List<String>>() {}.type)
    }
}