package com.example.retrofitgiris

import android.app.Activity
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import com.example.retrofitgiris.models.User


class Shared(val activity:Activity) {

    var shared:SharedPreferences = activity.getSharedPreferences("userFile",0 ) // Bulunulan sınıftan bir activity ile getSharedPreferences oluşturuldu
    var editor:Editor=shared.edit() // Editör nesnesi

    fun setUser(s:String,s2: String){ // Veri göndermek için
        editor.putString(s,s2)
        editor.commit()
    }

    fun getUser(s:String):String?{
        val data=shared.getString(s,null) // Veri almak için
        return data
    }


}