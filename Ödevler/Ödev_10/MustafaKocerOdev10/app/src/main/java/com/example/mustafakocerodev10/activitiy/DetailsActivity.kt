package com.example.mustafakocerodev10.activitiy

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.example.mustafakocerodev10.R
import com.example.mustafakocerodev10.config.AppDatabase
import com.example.mustafakocerodev10.dao.NotesDao
import com.example.mustafakocerodev10.databinding.ActivityDetailsBinding
import com.example.mustafakocerodev10.entity.Notes
import com.example.mustafakocerodev10.staticVariable.staticVars
import com.google.gson.Gson

class DetailsActivity : AppCompatActivity() {

    // Görüntüleme ve update işlemleri bu activity'de yapılacak
    private lateinit var notesDao: NotesDao
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarAddNote)

        val db = Room.databaseBuilder(
            this@DetailsActivity,
            AppDatabase::class.java,
            "notes_app_database"
        ).build()
        notesDao = db.createNotesDao()

        val gson = Gson()
        val notesJson = intent.getStringExtra("detailObj")
        val stNotes = gson.fromJson(notesJson, Notes::class.java)

        stNotes?.let {stNotess->
            Log.d("detailmenu", "$stNotes")
            binding.txtTitle.setText(stNotess.title)
            binding.txtDesc.setText(stNotess.description)
            binding.txtDate.text = stNotess.creationDate

            binding.bntDelete.setOnClickListener {
                val run1 = Runnable {
                    deleteNote(stNotess)
                    // veritabanından sildik, şimdi login activity'ye gitmeliyiz
                    val intent = Intent(this@DetailsActivity, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                Thread(run1).start()
            }

            binding.btnSave.setOnClickListener {
                val run = Runnable {
                    val title = binding.txtTitle.text.toString()
                    val desc = binding.txtDesc.text.toString()
                    val updatedNote = Notes(stNotess.nid!!.toInt(), staticVars.uid!!.toInt(),title,desc,stNotes.creationDate)
                    updateNote(updatedNote)
                    // veritabanında update ettik, şimdi login activity'ye gitmeliyiz
                    val intent = Intent(this@DetailsActivity, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                Thread(run).start()
            }
        }

    } // END OF ONCREATE

    fun updateNote(notes: Notes){
        notesDao.updateNote(notes)
    }

    fun deleteNote(notes: Notes) {
        notesDao.deleteNote(notes)
    }
}