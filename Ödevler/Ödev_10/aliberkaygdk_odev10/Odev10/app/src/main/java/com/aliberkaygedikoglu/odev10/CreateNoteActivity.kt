package com.aliberkaygedikoglu.odev10

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aliberkaygedikoglu.odev10.databinding.ActivityCreateNoteBinding
import com.aliberkaygedikoglu.odev10.entity.UserNote
import com.aliberkaygedikoglu.odev10.room.DB

class CreateNoteActivity : AppCompatActivity() {
    private lateinit var binding:ActivityCreateNoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateNoteBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val database = DB.getDatabase(this)
        binding.buttonCreate.setOnClickListener {
            if (binding.editTextCName.text.isNotEmpty() && binding.editTextCDetail.text.isNotEmpty()){
                database?.userNoteDao()?.insert(UserNote(null,binding.editTextCName.text.toString(),binding.editTextCDetail.text.toString()))
                finish()
            }else{
                Toast.makeText(this,"Bos bırakma",Toast.LENGTH_SHORT).show()
            }
        }
    }
}