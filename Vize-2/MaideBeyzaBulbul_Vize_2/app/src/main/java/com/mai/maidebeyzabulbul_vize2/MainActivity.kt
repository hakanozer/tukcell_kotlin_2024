package com.mai.maidebeyzabulbul_vize2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.jsoup.Jsoup
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {


    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchEditText: EditText = findViewById(R.id.searchedittext)
        val searchButton: Button = findViewById(R.id.searchButton)
        val showDetailButton = findViewById<Button>(R.id.showDetailButton)
        val resultCountTextView: TextView = findViewById(R.id.counterTextView)

        var searchResults: MutableList<String> = mutableListOf()



        searchButton.setOnClickListener {
            val searchKeyword = searchEditText.text.toString()
            thread {
                val doc = Jsoup.connect("https://www.w3schools.com/xml/plant_catalog.xml").get()
                val commonElements = doc.getElementsByTag("COMMON")
                var count = 0
                searchResults.clear()

                for (element in commonElements) {
                    if (element.text().contains(searchKeyword, ignoreCase = true)) {
                        count++
                        searchResults.add(element.parent().html())
                    }
                }

                runOnUiThread {
                    resultCountTextView.text = "Toplam $count sonuç bulundu."

                }
            }
        }
        showDetailButton.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putStringArrayListExtra("searchResults", ArrayList(searchResults))
            startActivity(intent)
        }
    }
}