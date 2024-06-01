package com.muratdayan.odev10.common.components

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.muratdayan.odev10.models.User

class UserSharedPrefManager(context:Context) {

    // customer dosyası oluşturur ve user bilgilerini kaydeder
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("customer", Context.MODE_PRIVATE)

    val editor = sharedPreferences.edit()

    fun setUserName(userName:String){
        editor.putString("username",userName)
        editor.commit()

    }

    fun getUserName() : String?{
        val sharedResult = sharedPreferences.getString("username",null) // dışardan gelen key ve default value değerlerine göre user dönüyor

        sharedResult?.let {
            return it
        }
        return null

    }

    fun deleteUser() {
        editor.remove("username")
        editor.apply()
        editor.commit()
    }
}