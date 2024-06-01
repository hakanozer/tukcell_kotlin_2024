package com.yeceylan.yunusemreceylan_odev10.presentation.detail

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.yeceylan.yunusemreceylan_odev10.R
import com.yeceylan.yunusemreceylan_odev10.databinding.ActivityDetailBinding
import com.yeceylan.yunusemreceylan_odev10.model.entity.Note
import com.yeceylan.yunusemreceylan_odev10.presentation.viewmodel.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val noteViewModel: NoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val noteId = intent.getIntExtra("note_id", -1)
        val noteTitle = intent.getStringExtra("note_title") ?: ""
        val noteContent = intent.getStringExtra("note_content") ?: ""
        val username = intent.getStringExtra("username") ?: ""

        binding.etNoteTitle.setText(noteTitle)
        binding.etNoteContent.setText(noteContent)

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }

        binding.btnUpdateNote.setOnClickListener {
            val updatedNote = Note(
                id = noteId,
                title = binding.etNoteTitle.text.toString(),
                content = binding.etNoteContent.text.toString(),
                username = username
            )
            noteViewModel.update(updatedNote)
            finish()
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}