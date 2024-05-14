package com.beyzaparlak.odev7

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.example.beyzaparlak.models.User
import com.google.gson.Gson


// Her kullanımda birden fazla sharedPreferences oluşturulmasın (singleton olsun) diye object kullandım
obejct SharedPrefManager(val context: Context) {

    private lateinit val sharedPreferences = context.getSharedPreferences("UserInfo", Context.MODE_PRIVATE)
    private val gson = Gson()

    // Editor nesnesi oluşturuyorum
    private val editor = sharedPreferences.edit()
    
    // Veri gönderme işlemi
    fun setUser(user: User){

	// user ı JSON stringine dönüştürüyorum
        val jsonUser = gson.toJson(user)
        editor.putString("user", jsonUser)
        // asenkron çalışmasını istiyorsak apply(), senkron çalışmasını istiyorsak commit() kullanırız
	editor.commit()

    }

    fun getUser(): User?{
        val jsonUser = sharedPreferences.getString("user", null)

        // jsonUser için null kontrolü yapıyorum
	if (jsonUser == null)
            return null
        // JSON Stringini user nesnesine return ediyorum
        return gson.fromJson(jsonUser, User::class.java)
    }

    

}