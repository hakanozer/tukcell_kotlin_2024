package com.muratdayan.vize2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar
import com.muratdayan.vize2.components.CustomToast
import com.muratdayan.vize2.databinding.ActivityMainBinding
import com.muratdayan.vize2.models.PlantModel
import com.muratdayan.vize2.services.Service

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbarMain: MaterialToolbar = binding.toolbarMain
        setSupportActionBar(toolbarMain)

        fun goToDetail(plant: PlantModel) {
            val i = Intent(this, DetailActivity::class.java)
            i.putExtra("plant", plant)
            startActivity(i)
        }


        binding.btnSearch.setOnClickListener {
            val searchedText = binding.editTxtPlantSearch.text.toString().trim().lowercase()

            Thread {
                val newplantList = Service().xmlLoad()
                println(newplantList[1].common)

                runOnUiThread {
                    if (newplantList.isNotEmpty() && searchedText.isNotEmpty()) {
                        val filteredList = newplantList.filter {
                            it.common.contains(searchedText, ignoreCase = true)

                        }

                        if (filteredList.size==0){
                            CustomToast(this,"Sıfır sonuç",Toast.LENGTH_SHORT).show()
                        }



                        binding.txtFoundPlantNumber.setText("${filteredList.size}")
                        binding.btnShowDetail.setOnClickListener {
                            if (filteredList.size != 0 && searchedText.isNotEmpty()) {
                                goToDetail(filteredList[0])
                            } else {
                                CustomToast(
                                    this,
                                    "Sonuç yok Aramanızı kontrol ediniz",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                    }else{
                        CustomToast(
                            this,
                            "Bir şey yazdınız mı?!!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }.start()


        }


    }
}