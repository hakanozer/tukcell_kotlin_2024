package com.tlh.deneme


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    private val text1: EditText by lazy { findViewById(R.id.et1) }
    private val text2: EditText by lazy { findViewById(R.id.et2) }
    private val text3: EditText by lazy { findViewById(R.id.et3) }
    private val signButton: Button by lazy { findViewById(R.id.button2) }
    private val signWithButton: Button by lazy { findViewById(R.id.button3) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        signButton.setOnClickListener {
            val passName: String = text2.text.toString()
            val password2: String = text3.text.toString()

            if (passName == userName || password2 == password) {
                val intentName: String = text1.text.toString()
                val intent2 = Intent(this, MainActivity2::class.java)
                intent2.putExtra("NamePassed", intentName)
                startActivity(intent2)
            } else {
                Toast.makeText(this, "Ayıp", Toast.LENGTH_LONG).show()
            }
        }

        signWithButton.setOnClickListener {
            val popupMenu = PopupMenu(this, signWithButton)
            popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { menuItem ->
                Toast.makeText(this, "You Clicked " + menuItem.title, Toast.LENGTH_SHORT).show()
                true
            }
            popupMenu.show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

const val password = "talha"
const val userName = "Talha"
