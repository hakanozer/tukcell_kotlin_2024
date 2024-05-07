package com.muratdayan.vize2

import android.content.Intent
import android.os.Bundle
import android.widget.PopupMenu
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar
import com.muratdayan.vize2.databinding.ActivityDetailBinding
import com.muratdayan.vize2.models.PlantModel

class DetailActivity : AppCompatActivity() {


    private lateinit var binding: ActivityDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbarDetail:MaterialToolbar = binding.toolbarDetail
        setSupportActionBar(toolbarDetail)

        toolbarDetail.setNavigationOnClickListener {
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
            finish()
        }

        val popUpMenu = PopupMenu(this,binding.btnShowInMenu)
        popUpMenu.menuInflater.inflate(R.menu.popup_menu,popUpMenu.menu)



        val plant = intent.getSerializableExtra("plant") as? PlantModel

        plant?.let {plantModel->
            binding.txtCommon.setText("yaygın ad: "+plantModel.common)
            binding.txtZone.setText("alan: "+plantModel.zone)
            binding.txtPrice.setText("fiyat: "+plantModel.price)
            binding.txtBotanical.setText("botanik: "+plantModel.botanical)
            binding.txtLight.setText("Işık Koşulu: "+plantModel.light)
            binding.txtAvailability.setText("mevcudiyet: "+plantModel.availability)

            val menuItemCommon = popUpMenu.menu.findItem(R.id.action_common)
            menuItemCommon.title = plantModel.common

            val menuItemZone = popUpMenu.menu.findItem(R.id.action_zone)
            menuItemZone.title = plantModel.zone

            val menuItemPrice = popUpMenu.menu.findItem(R.id.action_price)
            menuItemPrice.title = plantModel.price

            val menuItemBotanical = popUpMenu.menu.findItem(R.id.action_botanical)
            menuItemBotanical.title = plantModel.botanical

            val menuItemLight = popUpMenu.menu.findItem(R.id.action_light)
            menuItemLight.title = plantModel.light

            val menuItemAvailability = popUpMenu.menu.findItem(R.id.action_availability)
            menuItemAvailability.title = plantModel.availability
        }


        binding.btnShowInMenu.setOnClickListener {
            popUpMenu.show()
        }
    }


}