package com.example.yusuf_mucahit_solmaz_odev_10.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.yusuf_mucahit_solmaz_odev_10.databinding.ActivityUpdateNoteBinding
import com.example.yusuf_mucahit_solmaz_odev_10.db.service.NoteService

class UpdateNoteActivity : AppCompatActivity() {

    private lateinit var binding : ActivityUpdateNoteBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contactService= NoteService(this)

        val id=intent.getIntExtra("noteId",-1)

        binding.updateBtn.setOnClickListener {
            contactService.updateNotes(id,binding.noteTitleUptadeEditText.text.toString(),binding.noteUptadeEditText.text.toString().toInt())
            val i= Intent(this, NoteActivity::class.java)
            startActivity(i)
        }

    }
}