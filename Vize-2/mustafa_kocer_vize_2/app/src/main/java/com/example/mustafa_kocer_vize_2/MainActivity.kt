package com.example.mustafa_kocer_vize_2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mustafa_kocer_vize_2.databinding.ActivityMainBinding
import com.example.mustafa_kocer_vize_2.models.PlantCatalog
import com.example.mustafa_kocer_vize_2.services.XmlService
private lateinit var binding: ActivityMainBinding
private var filteredPlants : List<PlantCatalog>? = listOf()
private var resultCount : Int = 0
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // data binding icin gerekli islemler
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Datamı alıyorum
        var myPlantList : List<PlantCatalog> = listOf()
        Thread{
            myPlantList = XmlService().plantLoad()
        }.start()





        binding.btnAra.setOnClickListener {
            resultCount = 0
            val arananStr = binding.edtTxtSearch.text.toString()
            if (arananStr.isBlank() == false){
               filteredPlants = null
               // her butona basildiginda filteredPlants'i temizliyorum
               myPlantList?.let { myList ->
                   filteredPlants = myList.filter { it.COMMON.contains(arananStr) }
                   // aramaya uygun plantlerin listesi elimde
                   // eğer yoksa boş liste döndürüyor
               }

               filteredPlants?.let {
                   resultCount = it.size
                   binding.txtResults.text = "Bulunan Plant Sayısı : ${it.size}"
                /*
                   it.forEach {
                       println("Filtrelenen bitki : $it")
                   }
                 */
               }
           }
            else
                Toast.makeText(this,"Arama kısmı boş çalışamaz. Lütfen aramak istediğiniz kelimeyi girin.",Toast.LENGTH_SHORT).show()
        }



        //aktiviteler arasında geçme

    binding.btnGoDetails.setOnClickListener {
        if (resultCount != 0){
            // eğer aranan 1 tane bile sonuç bulmuşsa details kısmına öyle git
            filteredPlants?.let { plantCatalog->
                val intent = Intent(this, DetailActivity::class.java)

                val bundle = Bundle().apply {
                    putString("COMMON", plantCatalog[0].COMMON)
                    putString("BOTANICAL", plantCatalog[0].BOTANICAL)
                    putString("ZONE", plantCatalog[0].ZONE)
                    putString("LIGHT", plantCatalog[0].LIGHT)
                    putString("PRICE", plantCatalog[0].PRICE)
                    putString("AVAILABILITY", plantCatalog[0].AVAILABILITY)
                }
                intent.putExtras(bundle)
                resultCount = 0
                // tekrar aktiviteye döndüğünde details kısmına basıp eski ekrana dönmesin diye sıfırlıyorum
                startActivity(intent)
            }
        }
        else
            Toast.makeText(this, "Detay göstermeden önce geçerli bir arama işlemi yaptığınızdan emin olunuz!", Toast.LENGTH_SHORT).show()
    }


    }// end of the on create
}