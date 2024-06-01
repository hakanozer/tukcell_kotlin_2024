package com.emrecura.homework_10.presentation

import android.app.AlertDialog
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.marginBottom
import androidx.core.view.setPadding
import com.emrecura.homework_10.R
import com.emrecura.homework_10.databinding.ActivityDetailBinding
import com.emrecura.homework_10.model.NoteModel
import com.emrecura.homework_10.services.NoteService
import java.util.Date
import java.util.Locale

class DetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding
    private lateinit var noteService: NoteService
    private lateinit var clickedNote: NoteModel

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

        clickedNote = intent.getSerializableExtra("clickedNote") as NoteModel

        uiTexts(clickedNote)

        binding.deleteButton.setOnClickListener {
         deleteNote(clickedNote)
        }

        binding.updateButton.setOnClickListener {
            showUpdateNoteDialog(clickedNote.id)
        }

    }
    private fun uiTexts(clickedNote: NoteModel) {
        binding.detailTitle.text = clickedNote.title
        binding.detailText.text = clickedNote.detail
        binding.dateText.text = "Date : ${clickedNote.date}"
    }
    private fun deleteNote(clickedNote: NoteModel){
        val deleteRows = noteService.deleteNote(clickedNote.id)
        if (deleteRows>0){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }else {
            Toast.makeText(this,"Not Silinemedi!", Toast.LENGTH_LONG).show()
        }
    }

    private fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return dateFormat.format(Date())
    }

    private fun showUpdateNoteDialog(nid : Int) {
        val note = noteService.getNoteById(nid)

        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.dialog_note, null)

        val titleEditText = dialogLayout.findViewById<EditText>(R.id.titleEditText)
        val detailEditText = dialogLayout.findViewById<EditText>(R.id.detailEditText)

        titleEditText.hint = note?.title
        detailEditText.hint = note?.detail

        val dialog = AlertDialog.Builder(this)
            .setTitle("Update Note")
            .setView(dialogLayout)
            .setPositiveButton("Update") { dialog, _ ->
                var title = titleEditText.text.toString()
                var detail = detailEditText.text.toString()
                val date = getCurrentDate()

                // eğer title veya detail değiştirilmediyse aynı şekilde kalsın
                if (title.isEmpty()){
                    title = note!!.title
                }
                if (detail.isEmpty()){
                    detail = note!!.detail
                }


                val updateStatus = noteService.updateNote( title, detail, date, note!!.id)
                if (updateStatus > 0) {
                    // eğer update başarılı ise detail sayfasını anlık günceller
                    binding.detailTitle.text = title
                    binding.detailText.text = detail
                    binding.dateText.text = date
                } else {
                    Toast.makeText(this,"Not Güncellenemedi!", Toast.LENGTH_LONG).show()
                }

                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.cancel()
            }
            .create()

        dialog.show()
    }
}