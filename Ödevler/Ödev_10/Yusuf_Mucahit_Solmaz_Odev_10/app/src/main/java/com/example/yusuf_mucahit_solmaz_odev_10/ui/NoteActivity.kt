package com.example.yusuf_mucahit_solmaz_odev_10.ui

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.yusuf_mucahit_solmaz_odev_10.adapter.NoteAdapter
import com.example.yusuf_mucahit_solmaz_odev_10.databinding.ActivityNoteBinding
import com.example.yusuf_mucahit_solmaz_odev_10.db.entitiy.NoteDao
import com.example.yusuf_mucahit_solmaz_odev_10.db.service.NoteService


class NoteActivity : AppCompatActivity() {
   lateinit var binding: ActivityNoteBinding
    lateinit var lessons:List<NoteDao>
    private lateinit var adapter: NoteAdapter

    val contactService= NoteService(this)




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager=GridLayoutManager(this,1,GridLayoutManager.VERTICAL,false)

        binding.addBtn.setOnClickListener {
            val i=Intent(this, AddNoteActivity::class.java)
            startActivity(i)
        }

        lessons=contactService.listNotes()

        adapter= NoteAdapter(lessons)
        binding.recyclerView.adapter=adapter

        binding.search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                lessons = contactService.searchNotes(p0.toString())
                binding.recyclerView.adapter = NoteAdapter(lessons)
            }

            override fun afterTextChanged(s: Editable?) {
                //TODO("Not yet implemented")
            }


        })

    }
}