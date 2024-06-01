//Bu proje Umut Yusuf Çınar tarafından Geleceği Yazanlar Kotlin Ödev10 için oluşturuldu

/*
Hocam daha önce Flutter tarafında da SQLite kullandığım için SQLite kullanacağım.
Flutter'daki gibi abstract class üzerinden bir MVVM yapısı tanımlamak yerine
Android tarafında derste gördüğümüz gibi veri tabanı ve servis tasarımları yapacağım.
Çok fazla ekrana ve ekranlarda çok fazla elemente sahip olduğumuz için
Tasarım noktasında responsive olması için çevremdeki insanlara danıştım.
*/

package com.umutyusufcinar.odev10

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.PopupMenu
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.umutyusufcinar.odev10.R
import com.umutyusufcinar.odev10.adapter.NoteAdapter
import com.umutyusufcinar.odev10.databinding.ActivityMainBinding
import com.umutyusufcinar.odev10.models.Note
import com.umutyusufcinar.odev10.services.NoteService
import com.umutyusufcinar.odev10.utils.SwipeToDelete

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var noteService: NoteService
    private lateinit var noteAdapter: NoteAdapter
    private lateinit var allNotes:MutableList<Note>
    private var userId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //noteları tutan servis userId parametresiyle çalışacağız
        noteService = NoteService(this)
        userId = intent.getIntExtra("userId", -1)

        setUpFloatingActionButton()
        setUpRecyclerView()
        setUpSearchView()
        setUpMenu()

        swipeToDelete(binding.recyclerView)
    }

    override fun onResume() {
        super.onResume()
        //notları güncelledikten sonra
        //not listesinin de güncellenmesi için adapter kullanımı
        allNotes.clear()
        allNotes.addAll(noteService.getNotesForUser(userId))
        noteAdapter.notifyDataSetChanged()
    }

    //Buton ile sayfa geçişi
    private fun setUpFloatingActionButton() {
        binding.floatingActionAddNoteButton.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            intent.putExtra("userId", userId)
            startActivity(intent)
        }
    }
    //adapter kullanımı ile notları servisten veri çekerken yaptığımıza biraz benzer bir şekilde kullanma
    private fun setUpRecyclerView() {
        allNotes = noteService.getNotesForUser(userId)
        Log.d("allNotes",allNotes.toString())
        noteAdapter = NoteAdapter(allNotes)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = noteAdapter

        //tıklandığında notu görüntüleme için sayfa geçişi de olacak
        noteAdapter.onNoteClick = { note ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("noteId", note.nid)
            startActivity(intent)
        }
    }

    //Daha önceki ödevlerden kod olarak biraz farklı olsa da yine bir Search ve Query yapısı
    //bu noktada dersten ve internetten biraz yardım aldım
    private fun setUpSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                performSearch(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                performSearch(newText)
                return true
            }
        })
    }
    private fun performSearch(query: String?) {
        val trimmedQuery = query?.trim()
        if (trimmedQuery.isNullOrEmpty()) {//query eğer boşsa varsayılan listeye dönüş
            noteAdapter.updateNotes(allNotes)
        } else {
            val filteredNotes = noteService.searchNotes(trimmedQuery, userId)
            noteAdapter.updateNotes(filteredNotes) //query boş değilse update fonk ile güncelliyorum
        }
    }

    private fun setUpMenu() { //popup menu gösterip tüm notları silmeyi sorma evet hayır seçenekli
        binding.menuButton.setOnClickListener { view ->
            val popupMenu = PopupMenu(this, view)
            popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.deleteAll -> {
                        AlertDialog.Builder(this)
                            .setTitle("Tüm notları sil")
                            .setMessage("Tüm notları silmek istediğinize emin misiniz?")
                            .setPositiveButton("Evet") { _, _ ->
                                noteService.deleteAllNotesForUser(userId)
                                allNotes.clear()
                                noteAdapter.notifyDataSetChanged()
                                Toast.makeText(this, "Tüm Notlar Silindi!", Toast.LENGTH_SHORT).show()
                            }
                            .setNegativeButton("Hayır", ){dialog, _ ->
                                dialog.dismiss()
                            }
                            .show()
                        true
                    }R.id.logout -> {
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }

                    else -> false
                }
            }
            popupMenu.show()
        }
    }
    //tek bir notu silmek için fonksiyon evet hayır sorusu, popup yerine alert
    private fun swipeToDelete(recyclerView: RecyclerView) {
        val swipeHandler = object : SwipeToDelete() {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val note = allNotes[position]

                AlertDialog.Builder(this@MainActivity)
                    .setTitle("Not Silme")
                    .setMessage("Bu Notu Silmek İstediğine Emin misin?")
                    .setPositiveButton("Evet") { _, _ ->
                        noteService.deleteNoteById(note.nid)
                        allNotes.removeAt(position)
                        noteAdapter.notifyItemRemoved(position)
                        Toast.makeText(this@MainActivity, "Not Silindi", Toast.LENGTH_SHORT).show()
                    }
                    .setNegativeButton("Hayır",){ dialog, _ ->
                        dialog.dismiss()
                        noteAdapter.notifyItemChanged(position)
                    }
                    .show()
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }
}