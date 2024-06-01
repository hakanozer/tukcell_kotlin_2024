
package com.example.odev_10

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.odev_10.databinding.ActivityEditNoteBinding
import com.example.odev_10.models.Note
import com.example.odev_10.services.NoteService

class EditNote : AppCompatActivity() {

    private lateinit var binding: ActivityEditNoteBinding
    private lateinit var noteService: NoteService
    private lateinit var note: Note

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityEditNoteBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        noteService = NoteService(this)

        note = intent.getSerializableExtra("note") as Note

        binding.editTextTitleEdit.setText(note.title)
        binding.editTextContentEdit.setText(note.content)

        binding.btnSaveEdit.setOnClickListener {
            val title = binding.editTextTitleEdit.text.toString()
            val content = binding.editTextContentEdit.text.toString()

            val result = noteService.updateNote(note.nid, title, content)
            if (result > 0) {
                finish()
            }
            else {
                Toast.makeText(this, "Failed to update note", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnDontSaveEdit.setOnClickListener {
            finish()
        }
    }
}