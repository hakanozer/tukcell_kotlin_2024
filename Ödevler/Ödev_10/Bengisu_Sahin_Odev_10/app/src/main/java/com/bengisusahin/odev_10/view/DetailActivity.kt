package com.bengisusahin.odev_10.view

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bengisusahin.odev_10.R
import com.bengisusahin.odev_10.databinding.ActivityDetailBinding
import com.bengisusahin.odev_10.services.NoteService
import com.bengisusahin.odev_10.utils.DateUtils

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var noteService: NoteService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        noteService = NoteService(this)

        DateUtils.showDatePickerDialog(this, binding.etDetailDate)

        val noteId = intent.getIntExtra("noteId", -1)
        val note = noteService.getNoteById(noteId)

        note?.let {
            binding.apply {
                etDetailTitle.setText(it.title)
                etDetailDate.setText(it.date)
                etDetailContent.setText(it.content)
            }
        }
        // delete button click listener to delete the note
        binding.deleteButton.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Delete Note")
                .setMessage("Are you sure you want to delete this note?")
                .setPositiveButton("Yes") { _, _ ->
                    noteService.deleteNoteById(noteId)
                    Toast.makeText(this, "Note deleted", Toast.LENGTH_SHORT).show()
                    finish()
                }
                .setNegativeButton("No",){ _, _ ->
                    finish()
                }
                .setNeutralButton("Cancel", ){dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }

        // update button click listener to update the note
        binding.updateButton.setOnClickListener {
            val title = binding.etDetailTitle.text.toString()
            val date = binding.etDetailDate.text.toString()
            val content = binding.etDetailContent.text.toString()

            // check if there is any change in the note fields
            note?.let {
                if (title == it.title && date == it.date && content == it.content) {
                    Toast.makeText(this, "No changes made", Toast.LENGTH_SHORT).show()
                }else{
                    noteService.updateNoteById(noteId, title, date, content)
                    Toast.makeText(this, "Note updated", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }
}