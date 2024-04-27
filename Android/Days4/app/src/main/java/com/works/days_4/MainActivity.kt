package com.works.days_4

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.works.days_4.models.Customer
import com.works.days_4.models.User

class MainActivity : AppCompatActivity() {

    lateinit var btnGotoDetail: Button
    lateinit var txtData: EditText
    lateinit var btnSend: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnGotoDetail = findViewById(R.id.btnGotoDetail)
        txtData = findViewById(R.id.txtData)
        btnSend = findViewById(R.id.btnSend)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnGotoDetail.setOnClickListener {
            val i = Intent(this, DetailActivity::class.java)
            i.putExtra("age", 30)
            i.putExtra("name", "Erkan")
            val customer = Customer("Serkan", "Bilmem", "35")
            DetailActivity.customer = customer

            val user = User(100, "ali01", "12345")
            i.putExtra("user", user)
            startActivity(i)
        }

        btnSend.setOnClickListener {
            val data = txtData.text.toString().trim()
            if (data.equals("")) {
                //txtData.setBackgroundColor(Color.RED)
                //Toast.makeText(this, "Data Empty!", Toast.LENGTH_LONG).show()
                Snackbar.make(this, it, "Dat Empty!", Snackbar.LENGTH_SHORT).show()
            }else {

            }
        }
    }
}