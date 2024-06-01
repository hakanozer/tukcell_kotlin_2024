package com.example.yusuf_mucahit_solmaz_odev_10.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.yusuf_mucahit_solmaz_odev_10.databinding.ActivityAddNoteBinding
import com.example.yusuf_mucahit_solmaz_odev_10.db.service.NoteService


class AddNoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddNoteBinding
    private val contactService = NoteService(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addButton.setOnClickListener {
            val noteTitle = binding.addLessonName.text.toString()
            val note = binding.addNote.text.toString()
            contactService.saveNote(noteTitle, note)
            val intent = Intent(this, NoteActivity::class.java)
            startActivity(intent)
        }
    }
}