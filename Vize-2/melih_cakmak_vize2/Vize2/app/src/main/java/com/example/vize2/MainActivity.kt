package com.example.vize2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.vize2.model.Plant
import com.example.vize2.services.XmlService
import java.time.Duration

class MainActivity : AppCompatActivity() {

    lateinit var btnDetail:Button
    lateinit var btnSearch:Button
    lateinit var editTextSearch:EditText
    lateinit var searchResult: List<Plant>
    lateinit var txtSearhResult: TextView

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


        btnDetail=findViewById(R.id.btn_detail)
        editTextSearch=findViewById(R.id.edit_search)
        btnSearch=findViewById(R.id.btn_search)
        txtSearhResult=findViewById(R.id.txt_search_result)




        btnDetail.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }
        btnSearch.setOnClickListener {
            Thread{
                searchResult=XmlService().xmlSearch(editTextSearch.text.toString())
                txtSearhResult.text="Search Result: ${searchResult.size}"
                if (searchResult.isNotEmpty()){
                    DetailActivity.plant=searchResult.first()

                }




            }.start()



        }



    }
}