package com.works.days_4

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.works.days_4.models.Customer
import com.works.days_4.models.User
import org.json.JSONObject

class DetailActivity : AppCompatActivity() {

    companion object {
        var customer: Customer? = null
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // get extras
        val age = intent.getIntExtra("age", 0)
        val name = intent.getStringExtra("name")
        Log.d("age", age.toString())
        name?.let {
            Log.d("name", it)
            //Log.d("name", name)
        }

        customer?.let {
            Log.d("Customer", it.toString())
        }

        val user = intent.getSerializableExtra("user", User::class.java )
        user?.let {
            Log.d("user", it.toString())
        }
        if (user == null) {
            finish()
            System.exit(0)
        }


    }
}