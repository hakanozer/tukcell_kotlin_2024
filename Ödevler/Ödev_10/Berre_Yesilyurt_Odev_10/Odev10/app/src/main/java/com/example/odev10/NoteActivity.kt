package com.example.odev10

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.odev10.adapter.NoteAdapter
import com.example.odev10.models.Notes
import com.example.odev10.services.ContactServiceNotes

class NoteActivity : AppCompatActivity() {
    lateinit var recycler:RecyclerView
    lateinit var btnAdd:Button
    lateinit var search:EditText
    lateinit var lessons:List<Notes>
    lateinit var adapter:NoteAdapter

    val contactService=ContactServiceNotes(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        recycler=findViewById(R.id.recycler)
        btnAdd=findViewById(R.id.btnAdd)
        search=findViewById(R.id.search)

        recycler.layoutManager=GridLayoutManager(this,1,GridLayoutManager.VERTICAL,false)

        //contactService.addNote("Matematik",90)
        //contactService.addNote("Türkçe",70)
        //contactService.deleteNote(3)

        btnAdd.setOnClickListener {
            val i=Intent(this,AddNoteActivity::class.java)
            startActivity(i)
        }

        lessons=contactService.listNotes()
        Log.d("lessons",lessons.toString())
        adapter=NoteAdapter(lessons)
        recycler.adapter=adapter

        search.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    lessons = contactService.searchNotes(p0.toString())
                    Log.d("araştırılıyor", "araştır")
                    Log.d("search", lessons.toString())
                    recycler.adapter = NoteAdapter(lessons)
                    //adapter=NoteAdapter(lessons)
                    //adapter.notifyDataSetChanged()
                    //recycler.adapter=adapter
                }

                override fun afterTextChanged(p0: Editable?) {

                }


        })

        /*deneme.setOnClickListener {
            lessons=contactService.searchNotes(search.text.toString())
            Log.d("araştırılıyor","araştır")
            Log.d("search",lessons.toString())
            recycler.adapter=NoteAdapter(lessons)

        }*/



    }



    override fun onResume() {
        super.onResume()
        lessons=contactService.listNotes()
        Log.d("lessons",lessons.toString())
        adapter=NoteAdapter(lessons)
        recycler.adapter=adapter

    }
}