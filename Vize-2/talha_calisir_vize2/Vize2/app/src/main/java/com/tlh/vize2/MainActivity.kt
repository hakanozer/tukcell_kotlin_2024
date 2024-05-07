package com.tlh.vize2


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var userBtnDetail: Button
    private lateinit var userBtnSearch: Button
    private lateinit var userEditText: EditText
    private lateinit var userTxtSearchResult: TextView
    private lateinit var userSearchResult: List<Plant>

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        userBtnDetail = findViewById(R.id.userShowDetailsButton)
        userEditText = findViewById(R.id.userSearchEditText)
        userBtnSearch = findViewById(R.id.userSearchButton)
        userTxtSearchResult = findViewById(R.id.numberofFoundsTextView)

        userBtnDetail.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            startActivity(intent)
        }

        userBtnSearch.setOnClickListener {
            val searchTerm = userEditText.text.toString()

            Thread {
                userSearchResult = XmlService().xmlLoad().filter { plant ->
                    plant.common.contains(searchTerm, ignoreCase = true) && searchTerm.isNotEmpty()
                }

                runOnUiThread {
                    userTxtSearchResult.text = "Search Result: ${userSearchResult.size}"
                    if (userSearchResult.isNotEmpty()) {
                        DetailsActivity.compPlant = userSearchResult.first()
                    }
                }
            }.start()
        }
    }
}
