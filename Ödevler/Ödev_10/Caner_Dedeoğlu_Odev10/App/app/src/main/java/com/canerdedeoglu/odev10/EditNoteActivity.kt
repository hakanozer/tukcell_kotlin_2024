package com.canerdedeoglu.odev10

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.canerdedeoglu.odev10.models.Notes
import com.canerdedeoglu.odev10.services.NoteService

class EditNoteActivity : AppCompatActivity() {
    private lateinit var titleText: EditText
    private lateinit var descriptionText: EditText
    private lateinit var dateText: EditText
    private lateinit var categoryText: EditText
    private lateinit var updateButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_note)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        titleText = findViewById(R.id.title)
        descriptionText = findViewById(R.id.description)
        dateText = findViewById(R.id.date)
        categoryText = findViewById(R.id.category)
        updateButton = findViewById(R.id.kaydet)

        val noteId = intent.getIntExtra("noteId",-1)
        val noteTitle = intent.getStringExtra("noteTitle")
        val noteDescription = intent.getStringExtra("noteDescription")
        val noteDate = intent.getStringExtra("noteDate")
        val noteCategory = intent.getStringExtra("noteCategory")
        val userId = getUserId()

        titleText.setText(noteTitle)
        descriptionText.setText(noteDescription)
        dateText.setText(noteDate)
        categoryText.setText(noteCategory)

        updateButton.setOnClickListener {
            try {
                val updatedNote = updateNote(noteId, userId)
                if (updatedNote != null) {
                    Log.d("EditFragment", "Note updated: $updatedNote")
                    Toast.makeText(this, "Not güncellendi", Toast.LENGTH_SHORT).show()
                    finish()

                } else {
                    Toast.makeText(this, "Güncelleme başarısız", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Log.e("EditFragment", "Error updating note", e)
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun updateNote(noteId: Int, userId: Int): Notes? {
        val title = titleText.text.toString().trim()
        val description = descriptionText.text.toString().trim()
        val date = dateText.text.toString().trim()
        val category = categoryText.text.toString().trim()
        val noteService = NoteService(this)

        return if (title.isNotEmpty() && description.isNotEmpty() && date.isNotEmpty() && category.isNotEmpty()) {
            val note = Notes(noteId, title, description, date, category, userId)
            val success = noteService.updateNote(noteId, title, description, date, category, userId)
            if (success > 0) {
                note
            } else {
                null
            }
        } else {
            throw Exception("Lütfen tüm alanları doldurun.")
        }
    }

    private fun getUserId(): Int {
        val sharedPreferences = this.getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
        val userId = sharedPreferences.getInt("USER_ID", -1)
        if (userId == -1) {
                Log.e("EditActivity", "User ID not found")
        }
        return userId
    }
}