package com.sercancelik.libraryencryptedsharedpreferences

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var etName: EditText
    private lateinit var etAge: EditText
    private lateinit var btnSet: Button
    private lateinit var btnGet: Button
    private lateinit var btnClear: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        etName = findViewById(R.id.etName)
        etAge = findViewById(R.id.etAge)
        btnSet = findViewById(R.id.btnSet)
        btnGet = findViewById(R.id.btnGet)
        btnClear = findViewById(R.id.btnClear)

        val encryptSharedPrefenceManager = EncryptSharedPrefenceManager(this)
        btnSet.setOnClickListener {
            if (etName.text.isEmpty()) {
                Toast.makeText(this, "Lütfen Bir İsim Girin", Toast.LENGTH_SHORT).show()
            } else {
                encryptSharedPrefenceManager.name = etName.text.toString()
                encryptSharedPrefenceManager.age = etAge.text.toString().toInt()
            }

        }
        btnGet.setOnClickListener {

            etName.setText(encryptSharedPrefenceManager.name)
            etAge.setText(encryptSharedPrefenceManager.age.toString())
        }
        btnClear.setOnClickListener {
            etName.setText("")
            etAge.setText("")
        }

    }
}