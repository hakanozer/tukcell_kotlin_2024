package com.beyzaparlak.notesapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.beyzaparlak.notesapp.configs.AppDatabase
//import com.beyzaparlak.notesapp.configs.AppDatabase.Companion.createDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // createDatabase(this)

        // room
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "pro1"
        ).allowMainThreadQueries().build()

        // main(giriş ekranı) den sonra ilk olarak Register Activity açılsın istiyorum
        GlobalScope.launch(Dispatchers.IO) {
            val user = db.UsersDao().getRegisteredUser()
            withContext(Dispatchers.Main) {
                if (user != null) {
                    // Kullanıcı kayıtlıysa RegisterActivity'ye yönlendir
                    val loginIntent = Intent(this@MainActivity, RegisterActivity::class.java)
                    startActivity(loginIntent)
                } else {
                    // Kullanıcı kayıtlı değilse RegisterActivity'ye yönlendir
                    val registerIntent = Intent(this@MainActivity, RegisterActivity::class.java)
                    startActivity(registerIntent)
                }
                finish()
            }
        }

    }
}