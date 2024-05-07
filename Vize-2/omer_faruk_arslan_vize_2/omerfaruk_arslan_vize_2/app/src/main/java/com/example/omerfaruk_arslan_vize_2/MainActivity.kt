package com.example.omerfaruk_arslan_vize_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.omerfaruk_arslan_vize_2.model.Plant
import com.example.omerfaruk_arslan_vize_2.service.XmlService

class MainActivity : AppCompatActivity() {
    private lateinit var filteredPlants : List<Plant>
    private lateinit var txtSearch: EditText
    private lateinit var btnSearch: Button
    private lateinit var txtFind: TextView
    private lateinit var btnDetay: Button
    private lateinit var xmlService: XmlService
    private lateinit var plantList: List<Plant>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        txtSearch = findViewById(R.id.txtSearch)
        btnSearch = findViewById(R.id.btnSearch)
        txtFind = findViewById(R.id.txtFind)
        btnDetay = findViewById(R.id.btnDetay)
        xmlService = XmlService()

        btnSearch.setOnClickListener {
            search()
        }

        btnDetay.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            if (plantList.isNotEmpty()) {
                intent.putExtra("PLANT_DETAILS", filteredPlants.first())
            }
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        Thread {
            plantList = xmlService.xmlLoad()
            println(plantList)
        }.start()
    }

    private fun search() {
        val query = txtSearch.text.toString().trim()

        if (query.isEmpty()) {
            txtFind.text = "Hiçbir Şey Yazmadınız !"
            return
        }

        if (!::plantList.isInitialized) {
            txtFind.text = "Arama yapmadan önce veriler yüklenmeli!"
            return
        }

         filteredPlants = plantList.filter { plant ->
            plant.Common.lowercase().contains(query.lowercase())
        }

        txtFind.text = "Bulunanlar: ${filteredPlants.size}"
    }
}
