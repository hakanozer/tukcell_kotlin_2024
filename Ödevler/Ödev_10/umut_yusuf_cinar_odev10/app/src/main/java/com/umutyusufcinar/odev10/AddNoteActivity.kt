//yeni not ekleme ekranı
package com.umutyusufcinar.odev10

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.umutyusufcinar.odev10.R
import com.umutyusufcinar.odev10.adapter.NoteAdapter
import com.umutyusufcinar.odev10.databinding.ActivityAddNoteBinding
import com.umutyusufcinar.odev10.models.Note
import com.umutyusufcinar.odev10.services.NoteService
import com.umutyusufcinar.odev10.utils.DateUtils

class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var noteService: NoteService
    lateinit var allNotes:MutableList<Note>
    private var userId: Int = -1 //default değer gibi düşünebiliriz

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        noteService = NoteService(this)
        //activity nin başında userId alıyoruz
        userId = intent.getIntExtra("userId", -1)

        DateUtils.showDatePickerDialog(this, binding.dateEditText)

        //kaydetme butonuna tıklandığında veri tabanına kaydetme yapacağım
        binding.saveButton.setOnClickListener {
            val title = binding.titleEditText.text.toString()
            val content = binding.contentEditText.text.toString()
            val date = binding.dateEditText.text.toString()

            //boş alan varsa toast ile uyarı mesajı gösteriyorum
            if (title.isEmpty() || content.isEmpty() || date.isEmpty()) { //herhangi biri boş mu diye kontrol
                Toast.makeText(this, "Lütfen Tüm Alanları Doldurunuz!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else {
                val noteId = noteService.addNote(userId, title, content, date)
                // noteId değeri default değer olan -1 den farklıysa işlem başarılı
                // addNote metodu id döndürecek ve text alanları temizlenecek
                if (noteId > -1) {
                    binding.titleEditText.text.clear()
                    binding.contentEditText.text.clear()

                    //not ekleme işleminin başarılı olduğunu kullanıcıya toast ile gösterme
                    Toast.makeText(this, "Not Ekleme İşlemi Başarılı", Toast.LENGTH_SHORT).show()

                    // after adding the note, update the list
                    setResult(Activity.RESULT_OK)
                    finish()
                }
            }
        }
    }
}