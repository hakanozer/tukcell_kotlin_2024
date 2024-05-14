package com.example.odev7

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private lateinit var userPreferences: UserPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        userPreferences = UserPreferences(this)


        val user = User("Yusuf Mucahit Solmaz", 24)
        userPreferences.setUser(user)


        val currentUser = userPreferences.getUser()
        currentUser?.let {

            Log.d("User", "Name: ${it.name}, Age: ${it.age}")
            /***
            Output:

            Name: Yusuf Mucahit Solmaz, Age: 24
             */

        }
    }
}


data class User(val name: String, val age: Int)

class UserPreferences(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
    private val gson = Gson()

    /***
    Dependency olarak Gson ekledim. (implementation ("com.google.code.gson:gson:2.10.1"))
     */

    fun getUser(): User? {
        val userJson = sharedPreferences.getString("user", null)
        return gson.fromJson(userJson, User::class.java)
    }

    fun setUser(user: User) {
        val editor = sharedPreferences.edit()
        val userJson = gson.toJson(user)
        editor.putString("user", userJson)
        editor.apply()
    }
}