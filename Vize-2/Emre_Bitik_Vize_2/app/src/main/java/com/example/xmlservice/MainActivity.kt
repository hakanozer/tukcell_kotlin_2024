package com.example.xmlservice


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.Serializable


class MainActivity : AppCompatActivity() {

    lateinit var txtSearch :EditText
    lateinit var btnSend :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        txtSearch = findViewById(R.id.txtSearch)
        btnSend = findViewById(R.id.btnSend)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnSend.setOnClickListener {
            Thread{
                XmlService().xmlLoad()
            }.start()
            val data = XmlService().list
            val search  = txtSearch.text.toString()
            val i = Intent(this,ResultActivity::class.java)
            i.putExtra("plantList", data as Serializable)
            i.putExtra("search","$search")
            startActivity(i)
        }

    }
}