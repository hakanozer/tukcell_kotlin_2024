package com.ns.enesarisoy_odev11.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ns.enesarisoy_odev11.MainActivity
import com.ns.enesarisoy_odev11.configs.NoteOperations
import com.ns.enesarisoy_odev11.databinding.ActivityCreateBinding

class CreateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateBinding
    private lateinit var noteOperations: NoteOperations
    private var userId: Int = -1
    private var noteId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        noteOperations = NoteOperations(this)

        userId = intent.getIntExtra("USER_ID", -1)
        noteId = intent.getIntExtra("NOTE_ID", -1)

        if (userId == -1) {
            finish()
            return
        }

        with(binding) {

            if (noteId != -1) {
                val note = noteOperations.getNoteById(userId, noteId)
                note?.let {
                    noteTitle.setText(it.title)
                    noteContent.setText(it.content)
                }
            }

            ivBack.setOnClickListener {
                val title = noteTitle.text.toString()
                val content = noteContent.text.toString()
                if (title.isNotEmpty() || content.isNotEmpty()) {
                    if (noteId == -1) {
                        noteOperations.addNote(userId, title, content)
                    } else {
                        noteOperations.updateNote(userId, noteId, title, content)
                    }
                }
                startActivity(Intent(this@CreateActivity, MainActivity::class.java).apply {
                    putExtra("USER_ID", userId)
                })
                finish()
            }
        }
    }

}