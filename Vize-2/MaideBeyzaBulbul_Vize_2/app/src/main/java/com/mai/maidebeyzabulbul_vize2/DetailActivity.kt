package com.mai.maidebeyzabulbul_vize2

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Html
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.jsoup.Jsoup

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detailTextView: TextView = findViewById(R.id.detailtextview)

        val searchResults = intent.getStringArrayListExtra("searchResults")
        if (searchResults != null && searchResults.isNotEmpty()) {
            detailTextView.text = searchResults.joinToString(separator = "\n\n")
        } else {
            detailTextView.text = "Sonuç bulunamadı."
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }



}