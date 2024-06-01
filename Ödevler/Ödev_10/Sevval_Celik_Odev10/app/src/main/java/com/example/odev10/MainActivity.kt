package com.example.odev10

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.odev10.config.AppDatabase
import com.example.odev10.dao.NotesDao
import com.example.odev10.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var db: AppDatabase
    private lateinit var notesDao: NotesDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "pro1"
        ).build()

        notesDao = db.noteDao()



        GlobalScope.launch(Dispatchers.Main) {
            val userDB = withContext(Dispatchers.IO) {
                db.userDao().getRegisteredUser()
            }
            if (userDB != null) {
                val loginIntent = Intent(this@MainActivity, RegisterActivity::class.java)
                startActivity(loginIntent)
            } else {
                val registerIntent = Intent(this@MainActivity, RegisterActivity::class.java)
                startActivity(registerIntent)
            }
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        db.close()
    }

}