package com.example.eray_altilar_vize_2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.eray_altilar_vize_2.databinding.ActivityDetailBinding
import com.example.eray_altilar_vize_2.databinding.ActivityMainBinding
import com.example.eray_altilar_vize_2.model.CatalogData

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var searchResult: List<CatalogData>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        var searchResult = (intent.getSerializableExtra("Result") as List<CatalogData>).firstOrNull() ?: return

        /// teker teker searchResult içindeki bilgilerimizi textlerimize yazdırıyoruz
        with(binding) {
            txtCommon.text = searchResult.common
            txtBotanical.text = searchResult.botanical
            txtZone.text = searchResult.zone
            txtLight.text = searchResult.light
            txtPrice.text = searchResult.price
            txtAvailability.text = searchResult.availability
        }

        binding.btnBack.setOnClickListener{
            onBackPressed()
        }




    }
}