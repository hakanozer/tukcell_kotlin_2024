package com.example.eray_altilar_odev_10.presentation.homepage

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Menu
import android.widget.EditText
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eray_altilar_odev_10.R
import com.example.eray_altilar_odev_10.adapters.TaskAdapter
import com.example.eray_altilar_odev_10.databinding.ActivityHomepageBinding
import com.example.eray_altilar_odev_10.models.Note
import com.example.eray_altilar_odev_10.services.UserService
import com.google.android.material.snackbar.Snackbar
import java.util.*

class HomepageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomepageBinding
    private lateinit var taskAdapter: TaskAdapter
    private lateinit var userService: UserService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userService = UserService(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val userId = intent.getIntExtra(getString(R.string.userid), -1)

        taskAdapter = TaskAdapter(mutableListOf(), ::deleteNote, ::showEditNoteDialog)
        binding.RecyclerView.layoutManager = LinearLayoutManager(this)
        binding.RecyclerView.adapter = taskAdapter

        // Sayfa başladığında kullanıcıya ait notları al ve listeye ekle
        val getNotes = userService.getNotes(userId)
        taskAdapter.addNotes(getNotes)

        binding.floatingActionButton.setOnClickListener {
            //Kullaniciya ait bir not ekler
            userService.addNote(userId, getString(R.string.bir_eyler_yaz))

            val getNotes = userService.getNotes(userId)

            // Varsayılan bir not oluştur
            taskAdapter.addNotes(getNotes)

            // Hızlı işlem yapma durumlarında yazılar üst üste gelmesin diye Toast'u tercih etmedim
            Snackbar.make(binding.root, getString(R.string.note_added), Snackbar.LENGTH_SHORT).show()
        }

        binding.searchBar.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val searchText = s.toString().trim()

                // Arama metni boşsa, tüm öğeleri göster
                if (searchText.isEmpty()) {
                    val allNotes = userService.getNotes(userId)
                    taskAdapter.addNotes(allNotes)
                } else {
                    // Arama metni doluysa, veritabanında arama yap
                    val searchResults = userService.searchNotes(userId, searchText)
                    taskAdapter.addNotes(searchResults)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                /* sonar - comment */
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                /* sonar - comment */
            }
        })
    }

    private fun deleteNote(nid: Int) {
        val affectedRows = userService.deleteNote(nid)
        if (affectedRows > 0) {
            Toast.makeText(this, getString(R.string.not_silindi), Toast.LENGTH_SHORT).show()
            taskAdapter.removeNote(nid)
        } else {
            Toast.makeText(this, getString(R.string.not_silinirken_hata_olu_tu), Toast.LENGTH_SHORT).show()
        }
    }

    private fun showEditNoteDialog(note: Note) {
        val dialogView = layoutInflater.inflate(R.layout.note_edit_pop_up, null)
        val editText = dialogView.findViewById<EditText>(R.id.editNoteTitle)
        editText.setText(note.noteTitle)

        val dialog = AlertDialog.Builder(this)
            .setTitle("Notu Düzenle")
            .setView(dialogView)
            .setPositiveButton("Kaydet") { _, _ ->
                val newTitle = editText.text.toString()
                if (newTitle.isNotBlank()) {
                    note.noteTitle = newTitle
                    userService.updateNoteTitle(note.nid, newTitle)  // Veritabanında notu güncelle
                    taskAdapter.updateNote(note)  // Adapter'da notu güncelle
                    Toast.makeText(this, getString(R.string.not_g_ncellendi), Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, getString(R.string.ba_l_k_bo_olamaz), Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton(getString(R.string.ptal), null)
            .create()

        dialog.show()
    }
}
