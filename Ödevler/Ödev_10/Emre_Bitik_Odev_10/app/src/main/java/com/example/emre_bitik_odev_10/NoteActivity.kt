package com.example.emre_bitik_odev_10

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import com.example.emre_bitik_odev_10.adaptors.ProductAdaptors
import com.example.emre_bitik_odev_10.models.Note
import com.example.emre_bitik_odev_10.services.ContactService

class NoteActivity : AppCompatActivity() {
    lateinit var listViewProducts: ListView
    lateinit var txtSearch : EditText
    lateinit var btnAdd : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_note)
        listViewProducts= findViewById(R.id.listViewProducts)
        txtSearch = findViewById(R.id.txtSearch)
        btnAdd = findViewById(R.id.btnAdd)
        val  contactService = ContactService(this)

       val arr = contactService.allContanct()
        val productAdaptors = ProductAdaptors(this@NoteActivity, arr)
        listViewProducts.adapter = productAdaptors
        btnAdd.setOnClickListener() {

            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }
        // listviewde ki verilerin tıklanabilir olması
        listViewProducts.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedProduct = arr[position] // listedeki position konumuna göre elemanları alma
            val intent = Intent(this, DetailActivity::class.java)

            intent.putExtra("cid", selectedProduct.cid)
            intent.putExtra("title", selectedProduct.title)
            intent.putExtra("detail", selectedProduct.details)

            startActivity(intent)
        }

        // Arama Edittext anlık arama yapma
        txtSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                val productAdaptors = ProductAdaptors(this@NoteActivity, arr)
                listViewProducts.adapter = productAdaptors
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val textSearch = s.toString()
               val arrS=contactService.searchContanct(textSearch)
                val productAdaptors = ProductAdaptors(this@NoteActivity, arrS)
                listViewProducts.adapter = productAdaptors
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })



    }
}


