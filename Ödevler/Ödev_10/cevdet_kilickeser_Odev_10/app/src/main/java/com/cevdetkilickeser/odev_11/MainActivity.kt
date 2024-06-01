package com.cevdetkilickeser.odev_11

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.lifecycleScope
import com.cevdetkilickeser.odev_11.adapter.NotteAdapter
import com.cevdetkilickeser.odev_11.database.AppDatabase
import com.cevdetkilickeser.odev_11.databinding.ActivityMainBinding
import com.cevdetkilickeser.odev_11.entity.Notte
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var db: AppDatabase
    private lateinit var adapter: NotteAdapter
    private lateinit var dataList: List<Notte>
    private lateinit var notteList: MutableList<Notte>
    private var takenUserId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("Fatal","onCreate Çalıştı")

        db = AppDatabase.getDatabase(this)

        takenUserId = intent.getIntExtra("userId",-1)
        notteList = mutableListOf()

        adapter = NotteAdapter(notteList,this)
        binding.recyclerView.adapter = adapter

        val searchView = binding.searchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                notteList.clear()
                lifecycleScope.launch {
                    dataList = db.getNoteDao().searchNote(query)
                    notteList.addAll(dataList)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                return true
            }
        })

        try {
            getNottesFromRoom(takenUserId)
        }catch (_:Exception){}

        binding.fabAdd.setOnClickListener {
            navigateToDetailPage(takenUserId)
        }
    }

    private fun getNottesFromRoom(userId: Int) {
        lifecycleScope.launch {
            dataList = withContext(Dispatchers.IO) {
                db.getNoteDao().getAllNotes(userId)
            }
            notteList.addAll(dataList)
            adapter.notifyDataSetChanged()
        }
    }


    private fun navigateToDetailPage(userId: Int) {
        val intent = Intent(this@MainActivity,DetailActivity::class.java)
        intent.putExtra("userId",userId)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        try {
            getNottesFromRoom(takenUserId)
        }catch (_:Exception){}
    }
}