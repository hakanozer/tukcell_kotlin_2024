package com.example.mustafakocerodev10.activitiy

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.room.Room
import com.example.mustafakocerodev10.R
import com.example.mustafakocerodev10.adapter.RecyclerNotesAdapter
import com.example.mustafakocerodev10.config.AppDatabase
import com.example.mustafakocerodev10.dao.NotesDao
import com.example.mustafakocerodev10.dao.UserDao
import com.example.mustafakocerodev10.databinding.ActivityLoginBinding
import com.example.mustafakocerodev10.entity.Notes
import com.example.mustafakocerodev10.staticVariable.staticVars
import com.google.gson.Gson

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var notesDao: NotesDao
    private lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarLogin)

        val gson = Gson()
        val notesJson = intent.getStringExtra("addedObj")
        val stNotes = gson.fromJson(notesJson, Notes::class.java)

        val db = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "notes_app_database"
        ).build()

        notesDao = db.createNotesDao()
        userDao = db.createUserDao()

        stNotes?.let {
            val run1 = Runnable {
                writeToDatabase(it)
            }
            Thread(run1).start()
        }

        val run2 = Runnable {
            // db'den okuyup, recycler view'e ata
            val allNotes = readFromDatabase()
            binding.recyclerViewLogin.layoutManager = GridLayoutManager(
                this@LoginActivity, 2,
                GridLayoutManager.VERTICAL, false
            )
            val adapter = RecyclerNotesAdapter(allNotes.toMutableList())
            binding.recyclerViewLogin.adapter = adapter

            val textWatcher = object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    // Metin değişmeden önce yapılacak işlemler
                }
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }
                override fun afterTextChanged(s: Editable?) {
                    // Metin değiştikçe yapılacak işlemler
                    val text = binding.edtTxtSearch.text.toString()
                    if (text.isNotBlank()){
                        // arama islemi burada yapilacak ve adapter yeniden atanip yeniden listeleyeceksin
                        val filteredArr = allNotes.filter { it.title.contains(text, ignoreCase = true) }
                        val arrayAdapter = RecyclerNotesAdapter(filteredArr.toMutableList())
                        binding.recyclerViewLogin.adapter = arrayAdapter
                    }
                    else{
                        val arrayAdapter = RecyclerNotesAdapter(allNotes.toMutableList())
                        binding.recyclerViewLogin.adapter = arrayAdapter
                    }            }

            }
            binding.edtTxtSearch.addTextChangedListener(textWatcher)



        }
        Thread(run2).start()








    } // END OF onCreate

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_note_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.addNote -> {
                val intent = Intent(this@LoginActivity, AddNoteActivity::class.java)
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    fun readFromDatabase(): List<Notes> {
        val id = staticVars.uid!!.toInt()
        val allNotes = notesDao.getAllPersonelNotes(id)
        return allNotes
    }

    fun writeToDatabase(notes: Notes) {
        val id = staticVars.uid!!.toInt()
        val result = notesDao.insertNote(notes)
    }

} // END OF LoginActivity