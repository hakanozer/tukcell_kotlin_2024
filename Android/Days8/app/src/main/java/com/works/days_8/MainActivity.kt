package com.works.days_8

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.works.days_8.configs.ApiClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val dt1 = ApiClient.getClient()
        Log.d("dt1", dt1.hashCode().toString())
        val dt2 = ApiClient.getClient()
        Log.d("dt2", dt2.hashCode().toString())
        val dt3 = ApiClient.getClient()
        Log.d("dt3", dt3.hashCode().toString())

        call()
    }

    fun call() {
        val dt4 = ApiClient.getClient()
        Log.d("dt4", dt4.hashCode().toString())
    }
}