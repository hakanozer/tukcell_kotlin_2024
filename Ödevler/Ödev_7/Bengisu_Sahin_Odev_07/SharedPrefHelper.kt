package com.bengisusahin.days_8

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.bengisusahin.days_8.models.User
import com.google.gson.Gson

// Her sharedPreferences kullanımında birden fazla sharedPreferences oluşmaması için,
// Singleton olması için object anahtar kelimesi ile bir sınıf oluşturuldu.
object SharedPrefHelper {

    private lateinit var sharedPreferences: SharedPreferences
    private val gson = Gson()

    // object'lerde constructor izni olmadığı için context i aldığı yerde sharedPreferences oluşması için
    fun init(context: Context){
        sharedPreferences = context.getSharedPreferences("customer", AppCompatActivity.MODE_PRIVATE)
    }


    fun getUser() : User? {
        val stUser = sharedPreferences.getString("user", null)
        // user boş değilse JSON Stringini user nesnesine geri döndürülür
        return stUser?.let {
            gson.fromJson(it, User::class.java)
        }
    }

    fun setUser(user: User){
        // User nesnesini Json stringine dönüştürür
        val stUser = gson.toJson(user)
        //apply() verileri asyncronous kaydetmek için kullanılır.
        sharedPreferences.edit().putString("user", stUser).apply()
    }

}