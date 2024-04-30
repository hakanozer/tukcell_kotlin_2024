package com.works.days_6

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.PopupMenu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuBuilder
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var btnPopUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        btnPopUp = findViewById(R.id.btnPopUp)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val popUp = PopupMenu(this, btnPopUp )
        popUp.menuInflater.inflate(R.menu.main, popUp.menu)
        popUp.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.itm_product -> {
                    Log.d("Item-", "Product Click")
                    true
                }
                R.id.itm_basket -> {
                    Log.d("Item-", "Basket Click")
                    true
                }
                R.id.itm_profile -> {
                    Log.d("Item-", "Profile Click")
                    true
                }
                else -> false
            }
        }
        btnPopUp.setOnClickListener {
            popUp.show()
        }

    }

    @SuppressLint("RestrictedApi")
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val builder = menu as MenuBuilder
        builder.setOptionalIconsVisible(true)
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.itm_product -> {
                Log.d("Product", "onOptionsItemSelected Product")
                true
            }
            R.id.itm_basket -> {
                Log.d("Basket", "onOptionsItemSelected Basket")
                true
            }
            R.id.itm_profile -> {
                Log.d("Profile", "onOptionsItemSelected Profile")
                true
            }
            else -> false
        }
    }

}