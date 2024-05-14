package com.muratdayan.days_8.configs

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.muratdayan.days_8.R
import com.muratdayan.days_8.models.User

class SharedPreferencesManager(context: Context) {


    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("customer", Context.MODE_PRIVATE)

    val editor = sharedPreferences.edit()
    val gson = Gson()

    fun setUser(key:String,user:User){
        val userJson = gson.toJson(user) // user nesnesini json string yapıyoruzz
        editor.putString(key,userJson)
        editor.commit()

    }

    fun getUser(key: String, defaultValue:String?) : User?{
        val sharedResult = sharedPreferences.getString(key,defaultValue) // dışardan gelen key ve defaultvalue değerilerine gçre user dönüyor

        sharedResult?.let {
            val user = gson.fromJson(it, User::class.java) // json stringini user'e döndürüyoruz
            return user
        }
        return null

    }
}

/*
MAIN ACTIVITY
lateinit var sharedPreferencesManager: SharedPreferencesManager
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContentView(R.layout.activity_main)
    sharedPreferencesManager = SharedPreferencesManager(this)
    sharedPreferencesManager.setUser("user", it)
}*/

/*
WELCOME ACTIVITY

class WelcomeActivity : AppCompatActivity() {

    lateinit var sharedPreferencesManager: SharedPreferencesManager



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)


        sharedPreferencesManager = SharedPreferencesManager(this)

        val user = sharedPreferencesManager.getUser("user",null)

        user?.let {
            println(user.toString())
        }

    }
}*/


