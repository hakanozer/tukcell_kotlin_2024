package com.aliberkaygedikoglu.odev10

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.aliberkaygedikoglu.odev10.adapter.NotesAdapter
import com.aliberkaygedikoglu.odev10.databinding.ActivityMainBinding
import com.aliberkaygedikoglu.odev10.entity.User
import com.aliberkaygedikoglu.odev10.entity.UserNote
import com.aliberkaygedikoglu.odev10.room.DB
import java.util.Locale


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val database = DB.getDatabase(this)

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
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
        Log.d("lifecycle","onCreate")

        val getUser = intent.getSerializableExtra("user", User::class.java)



        binding.rV.layoutManager = LinearLayoutManager(this)
        val notesAdapter = getUser?.id?.let { database?.userNoteDao()?.getAll(it)?.let { NotesAdapter(it) } }
        binding.rV.adapter = notesAdapter



        getUser?.id?.let { database?.userNoteDao()?.getAll(it).let {
            if (it != null) {
                searchListener(it)
            }
        } }

        binding.buttonNew.setOnClickListener {
            val intent = Intent(this@MainActivity,CreateNoteActivity::class.java)
            startActivity(intent)
        }
    }


    //arama kısmını düzgün yapamadım
    //bir çözüm için detaylı inceleme gerekli
    //burada bir sıkıntı var recyclerview düzgün çalışmıyor
    private fun searchListener(arr: List<UserNote>) {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean { // Klavye üzerindeki arama iconu ile çalışır.

                val filteredList = arr.filter { it.name.lowercase().contains(query) }
                binding.rV.adapter = NotesAdapter( filteredList)
                binding.rV.adapter?.notifyDataSetChanged()
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean { // Harf girdikçe veya sildikçe çalışır.

                return false
            }
        })
    }


    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onResume() {
        super.onResume()
        Log.d("lifecycle","onresume")
        val getUser = intent.getSerializableExtra("user", User::class.java)
        val notesAdapter = getUser?.id?.let { database?.userNoteDao()?.getAll(it)?.let { NotesAdapter(it) } }
        binding.rV.adapter = notesAdapter

    }
}