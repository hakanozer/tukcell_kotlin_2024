package com.example.days8kendim.services

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import com.example.days8kendim.models.UserModel
import com.google.gson.Gson

class SharedPreferencesClass(val context: Context, val xml_file_name:String, val mode : Int ) {
    private lateinit var shared : SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    init {
        shared = context.getSharedPreferences(xml_file_name, mode)
        editor = shared.edit()
    }

    fun setUser( keyName:String, model : UserModel){
        val gson = Gson()
        val stUser = gson.toJson(model)
        // Gson kutuphanesi ile modelimi JSON türüne çeviriyorum 
        // çevirdiğim modelimi SharedPreferences'a yazıyorum
        editor.putString(keyName,stUser)
        editor.commit()
    }

    fun getUser(keyName: String): UserModel?{
        val gson = Gson()
        val stUser = shared.getString(keyName,null)
	// SharedPreferences'dan verimi okuyorum
       

        stUser?.let {
            val model = gson.fromJson(it, UserModel::class.java)
	// Gson kutuphanesi ile JSON türünde sakladığım veriyi UserModel türüne çeviriyorum
            return model
        }
        return null
    }

}
