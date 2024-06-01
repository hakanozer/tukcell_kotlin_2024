package com.cevdetkilickeser.odev_11

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.cevdetkilickeser.odev_11.database.AppDatabase
import com.cevdetkilickeser.odev_11.databinding.ActivityDetailBinding
import com.cevdetkilickeser.odev_11.entity.Notte
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var db: AppDatabase

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getDatabase(this)

        val takenUserId = intent.getIntExtra("userId",-1)
        val takenNotte = intent.getSerializableExtra("notte") as? Notte

        loadDetailPage(takenNotte)

        binding.fabDone.setOnClickListener {
            addOrUpdateNotte(takenNotte, takenUserId)
        }

        binding.buttonDelete.setOnClickListener {
            deleteNote(takenNotte)
        }
    }

    private fun loadDetailPage(takenNotte: Notte?) {
        takenNotte?.let { notte ->
            binding.textTitle.setText(notte.title)
            binding.textDetail.setText(notte.detail)
        }
    }

    private fun addOrUpdateNotte(takenNotte: Notte?, takenUserId: Int) {
        lifecycleScope.launch {
            val newTitle = binding.textTitle.toString()
            val newDetail = binding.textDetail.toString()

            withContext(Dispatchers.IO) {
                takenNotte?.let { notte ->
                    val newNotte = Notte(notte.id, takenUserId, newTitle, newDetail)
                    db.getNoteDao().updateNote(newNotte)
                } ?: run {
                    val newNotte = Notte(0, takenUserId, newTitle, newDetail)
                    db.getNoteDao().insertNote(newNotte)
                    Log.e("Fatal","kaydedildi")
                }
            }

            withContext(Dispatchers.Main) {
                Snackbar.make(binding.root, "Not kaydedildi.", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    private fun deleteNote(takenNotte: Notte?) {
        takenNotte?.let { notte ->
            db.getNoteDao().deleteNote(notte)
        } ?: run {
            onBackPressed()
        }
    }
}