package com.example.vize2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.vize2.model.Plant

class DetailActivity : AppCompatActivity() {

    lateinit var txtCommon: TextView
    lateinit var txtBotanical: TextView
    lateinit var txtZone: TextView
    lateinit var txtLight: TextView
    lateinit var txtPrice: TextView
    lateinit var txtAvailability: TextView
    lateinit var  imageButton: ImageButton

    companion object{
         var plant:Plant? = null
    }



    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        txtCommon=findViewById(R.id.txtCommon)
        txtBotanical=findViewById(R.id.txtBotanical)
        txtZone=findViewById(R.id.txtZone)
        txtLight=findViewById(R.id.txtLight)
        txtPrice=findViewById(R.id.txtPrice)
        txtAvailability=findViewById(R.id.txtAvailability)
        imageButton=findViewById(R.id.backButton)


        if(plant!=null){
            txtCommon.text = "COMMON:"+plant!!.common
            txtBotanical.text= "BOTANICAL:"+plant!!.botanical
            txtZone.text= "ZONE:"+plant!!.zone.toString()
            txtLight.text="LIGHT:"+ plant!!.light
            txtPrice.text= "PRICE:"+plant!!.price
            txtAvailability.text="AVAILABILITY:"+ plant!!.availability
        }
        imageButton.setOnClickListener {
            onBackPressed()
            DetailActivity.plant=null
            finish()
        }
    }
}