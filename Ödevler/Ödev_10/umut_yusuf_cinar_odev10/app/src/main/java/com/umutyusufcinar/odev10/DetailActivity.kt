package com.umutyusufcinar.odev10

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.umutyusufcinar.odev10.R
import com.umutyusufcinar.odev10.databinding.ActivityDetailBinding
import com.umutyusufcinar.odev10.services.NoteService
import com.umutyusufcinar.odev10.utils.DateUtils

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
        //yine default value -1
        val noteId = intent.getIntExtra("noteId", -1)
        val note = noteService.getNoteById(noteId)

        note?.let {
            binding.apply {
                etDetailTitle.setText(it.title)
                etDetailDate.setText(it.date)
                etDetailContent.setText(it.content)
            }
        }
        //silmek için delete butonuna listener ve popup yerine alert
        binding.deleteButton.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Not Silme İşlemi")
                .setMessage("Bu Notu Silmek İstediğinize Emin misiniz?")
                .setPositiveButton("Evet") { _, _ ->
                    noteService.deleteNoteById(noteId)
                    Toast.makeText(this, "Not Silinme İşlemi Başarılı", Toast.LENGTH_SHORT).show()
                    finish()
                }
                .setNegativeButton("Hayır",){ _, _ ->
                    finish()
                }
                .setNeutralButton("İptal", ){dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }

        //güncelleme için update butonuna listener
        binding.updateButton.setOnClickListener {
            val title = binding.etDetailTitle.text.toString()
            val date = binding.etDetailDate.text.toString()
            val content = binding.etDetailContent.text.toString()

            //değişiklik olup olmadığının kontrolünü yapıyorum ve durumlara göre toast atıyorum
            note?.let {
                if (title == it.title && date == it.date && content == it.content) {
                    Toast.makeText(this, "Notta Herhangi Bir Değişiklik Yapılmadı", Toast.LENGTH_SHORT).show()
                }else{
                    noteService.updateNoteById(noteId, title, date, content)
                    Toast.makeText(this, "Not Güncellendi", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }
}