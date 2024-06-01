package com.aliberkaygedikoglu.odev10

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aliberkaygedikoglu.odev10.databinding.ActivityDetailBinding
import com.aliberkaygedikoglu.odev10.entity.User
import com.aliberkaygedikoglu.odev10.entity.UserNote
import com.aliberkaygedikoglu.odev10.room.DB

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
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

        val database = DB.getDatabase(this)
        val note = intent.getSerializableExtra("note", UserNote::class.java)

        binding.editTextName.setText(note?.name)
        binding.editTextDetail.setText(note?.detail)



        binding.buttonSave.setOnClickListener {

            database?.userNoteDao()?.update(UserNote(note?.id,binding.editTextName.text.toString(),binding.editTextDetail.text.toString()))
            finish()
        }

    }
}