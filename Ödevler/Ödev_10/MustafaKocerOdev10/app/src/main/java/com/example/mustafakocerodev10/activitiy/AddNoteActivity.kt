package com.example.mustafakocerodev10.activitiy

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mustafakocerodev10.R
import com.example.mustafakocerodev10.databinding.ActivityAddNoteBinding
import com.example.mustafakocerodev10.entity.Notes
import com.example.mustafakocerodev10.staticVariable.staticVars
import com.google.gson.Gson
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class AddNoteActivity : AppCompatActivity() {
    // sıfırdan not ekleme işlemi bu sayfada yapılacak, diğer aktiviteye bir notes nesnesi taşınmalı.
    private lateinit var binding: ActivityAddNoteBinding
    private var uid: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_note)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarAddNote)

        binding.btnAddNotes.setOnClickListener {
            val obj = controlNote()
            obj?.let {
                val intent = Intent(this@AddNoteActivity, LoginActivity::class.java)
                val gson = Gson()
                val stNotes = gson.toJson(it)
                intent.putExtra("addedObj", stNotes)
                startActivity(intent)
                finish()
            }
        }

    }


    fun createDate(): String {
        val currentDate = Date()
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val formattedDate = dateFormat.format(currentDate)

        val dayOfMonth = formattedDate.substring(0, 2)
        val year = formattedDate.substring(6, 10)

        val monthFormat = SimpleDateFormat("MMM", Locale.getDefault())
        val monthString = monthFormat.format(currentDate)
        val firstThreeLetters = monthString.substring(0, 3)
        val today = buildString {
            append(dayOfMonth)
            append(" ")
            append(firstThreeLetters)
            append(" ")
            append(year)
        }
        return today
    }

    fun controlNote(): Notes? {
        val title = binding.edtTxtTitle.text.toString()
        val desc = binding.edtTxtDesc.text.toString()
        if (title.isBlank()) {
            Toast.makeText(this@AddNoteActivity, "Please add a title", Toast.LENGTH_LONG).show()
        } else {
            val date = createDate()
            // baslik dolu, veri not olarak eklenebilir
            val myObj = Notes(null, staticVars.uid!!, title, desc, date)
            return myObj
        }

        return null
    }

}