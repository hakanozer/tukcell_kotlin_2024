package com.example.odev_7_study

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val sharedPref = SharedPref(this)

        // set user ile veri kaydediliyor
        val stUser = User("Eray" , "Altilar")
        sharedPref.setUser(stUser)

        // get user ile veri yazdırılıyor
        val gtUser = sharedPref.getuser()
        Log.d("user" , gtUser.toString())

    }
}

