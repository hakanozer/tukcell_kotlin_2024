package com.example.odev_10

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.odev_10.databinding.ActivityAddNoteBinding
import com.example.odev_10.services.NoteService

class AddNote : AppCompatActivity() {

    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var noteService: NoteService
    private var userId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityAddNoteBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        noteService = NoteService(this)
        userId = intent.getIntExtra("userId", 0)

        binding.btnSaveAdd.setOnClickListener {
            val title = binding.editTextTitleAdd.text.toString()
            val content = binding.editTextContentAdd.text.toString()
            if (title.isEmpty() || content.isEmpty()) {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            }
            else{
                val result = noteService.addNote(userId, title, content)
                if (result > 0) {
                    finish()
                }
            }
        }

        binding.btnDontSaveAdd.setOnClickListener {
            finish()
        }
    }
}