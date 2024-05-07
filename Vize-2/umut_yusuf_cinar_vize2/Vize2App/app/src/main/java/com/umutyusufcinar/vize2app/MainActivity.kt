package com.umutyusufcinar.vize2app
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.umutyusufcinar.vize2app.service.Common
import com.umutyusufcinar.vize2app.service.XmlService

class MainActivity : AppCompatActivity() {
    private lateinit var searchBar: EditText
    private lateinit var searchButton: Button
    private lateinit var totalResultsTextView: TextView
    private lateinit var detailsButton: Button
    private lateinit var xmlService: XmlService
    private lateinit var plantList: List<Common>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //xml sayfasından bileşenleri değişkenlere aldım
        searchBar = findViewById(R.id.search_bar)
        searchButton = findViewById(R.id.search_button)
        totalResultsTextView = findViewById(R.id.total_results)
        detailsButton = findViewById(R.id.details_button)

        xmlService = XmlService() //servis için bir obje oluşturuyorum

        //Arama butonuna tıklandığında çalışacak listener yazıyorum
        searchButton.setOnClickListener {
            search()
        }

        // Yeni detay butonu için listener oluşturup bu butona tıklanınca
        // arama verilerinin detay sayafasına aktarılmasını
        //intent yapısı ile sağlıyorum
        plantList = xmlService.xmlLoad()
        Thread{
            println(plantList)
        }.start()

        val detailsButton = findViewById<Button>(R.id.details_button)
        detailsButton.setOnClickListener {
            // DetailsActivity'ye veri gönderme
            val intent = Intent(this, DetailsActivity::class.java)
            if (plantList.isNotEmpty()) {
                intent.putExtra("PLANT_DETAILS", plantList.first())  // Parcelable nesnesini ekleyin
            }
            startActivity(intent)  // DetailsActivity'ye geçiş yap
        }
    }

    // Arama metodunu oluşturuyorum
    fun search() {
        val query = searchBar.text.toString().trim()

        if (query.isEmpty()) {
            totalResultsTextView.text = "Lütfen arama yerine bir şeyler yazın" //Boş arama yapılmaması için kontrol yazdım
            return
        }

        //Veriyi XmlService'den alıp bir collection içinde tutuyorum
        val allPlants = xmlService.xmlLoad()

        //"COMMON" alanında arama yapmak için listemi filtreliyorum
        plantList = allPlants.filter { plant ->
            plant.commonName.lowercase().contains(query.lowercase())
        }

        //Toplam sonuçları güncelle
        totalResultsTextView.text = "Total Results: ${plantList.size}"
    }
}

