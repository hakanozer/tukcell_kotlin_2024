package com.bengisusahin.bengisu_sahin_vize02

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bengisusahin.bengisu_sahin_vize02.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var bindingDetail : ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingDetail = ActivityDetailBinding.inflate(layoutInflater)
        val viewDetail = bindingDetail.root

        enableEdgeToEdge()

        setContentView(viewDetail)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // MAinActivityde Xml serviceden çekilden bitkinin detaylarını bu aktivityde göstermek icin
        // getStringExtra methoddunu kullandık
        val detailCommon = intent.getStringExtra("detailCommon")
        val detailBotanical = intent.getStringExtra("detailBotanical")
        val detailZone = intent.getStringExtra("detailZone")
        val detailLight = intent.getStringExtra("detailLight")
        val detailPrice = intent.getStringExtra("detailPrice")
        val detailAvailability = intent.getStringExtra("detailAvailability")

        val textDetail = "$detailCommon \n$detailBotanical \n$detailZone \n" +
                "$detailLight\n$detailPrice\n$detailAvailability"
        //Log.d("detail", textDetail!!)
        bindingDetail.textViewDetail.text = textDetail


        // geri butonuna basıldığında main activitye dönülmesi icin startActivity(intent)
        // finish sayesinde de butona basmadan geri buraya gelemiyoruz
        bindingDetail.buttonBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}