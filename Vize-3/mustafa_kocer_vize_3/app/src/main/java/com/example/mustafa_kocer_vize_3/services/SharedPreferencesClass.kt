package com.example.mustafa_kocer_vize_3.services

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson

class SharedPreferencesClass(val context: Context, val xml_file_name:String, val mode : Int ) {
    private lateinit var shared : SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    init {
        shared = context.getSharedPreferences(xml_file_name, mode)
        editor = shared.edit()
    }

    fun setStr( keyName:String, string : String){
        editor.putString(keyName,string)
        editor.commit()
    }

    fun getStr(keyName: String): String?{
        val stUser = shared.getString(keyName,null)
        // SharedPreferences'dan verimi okuyorum
        stUser?.let {
            return it
        }
        return null
    }



}