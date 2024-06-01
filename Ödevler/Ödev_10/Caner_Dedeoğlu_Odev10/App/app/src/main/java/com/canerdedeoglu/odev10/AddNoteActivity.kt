package com.canerdedeoglu.odev10

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.canerdedeoglu.odev10.models.Notes
import com.canerdedeoglu.odev10.services.NoteService

class AddNoteActivity : AppCompatActivity() {

    private lateinit var new_note_title: EditText
    private lateinit var new_note_description: EditText
    private lateinit var new_note_date: EditText
    private lateinit var new_note_category: EditText
    private lateinit var new_note_kaydet: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_note)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        new_note_title = findViewById(R.id.new_note_title)
        new_note_description = findViewById(R.id.new_note_description)
        new_note_date = findViewById(R.id.new_note_date)
        new_note_category = findViewById(R.id.new_note_category)
        new_note_kaydet = findViewById(R.id.new_note_kaydet)

        new_note_kaydet.setOnClickListener {

            newNote()
            finish()
        }

    }

    private fun newNote() {

        val noteService = NoteService(this)
        val userId = getUserId()
        val title = new_note_title.text.toString()
        val description = new_note_description.text.toString()
        val date = new_note_date.text.toString()
        val category = new_note_category.text.toString()

        if (title.isNotEmpty() && description.isNotEmpty() && date.isNotEmpty() && category.isNotEmpty()) {
            noteService.addNote(title, description, date, category, userId)
        } else {
            throw Exception("Lütfen tüm alanları doldurun.")
        }


    }

    private fun getUserId(): Int {
        val sharedPreferences = this.getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
        val userId = sharedPreferences.getInt("USER_ID", -1)
        if (userId == -1) {
            Log.e("AddNoteActivity", "User ID not found")
        }
        return userId
    }

}