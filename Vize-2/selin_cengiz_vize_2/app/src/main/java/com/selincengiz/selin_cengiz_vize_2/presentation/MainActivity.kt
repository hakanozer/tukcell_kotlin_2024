package com.selincengiz.selin_cengiz_vize_2.presentation

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.selincengiz.selin_cengiz_vize_2.R
import com.selincengiz.selin_cengiz_vize_2.common.Resource
import com.selincengiz.selin_cengiz_vize_2.data.entities.PlantResponse
import com.selincengiz.selin_cengiz_vize_2.data.source.XmlService
import com.selincengiz.selin_cengiz_vize_2.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var searchList = mutableListOf<PlantResponse>()
    private var result: Resource<Boolean>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainFunctions = this
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val job = lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                result = XmlService().xmlLoadPlant()
            }
        }

        job.start()
        job.invokeOnCompletion {
            when (result) {
                is Resource.Success -> {
                    Toast.makeText(
                        this@MainActivity,
                        "Xml load is successfull",
                        Toast.LENGTH_LONG
                    ).show()
                }

                is Resource.Error -> {
                    Toast.makeText(
                        this@MainActivity,
                        (result as Resource.Error).throwable.message.toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }

                null -> {
                    Toast.makeText(
                        this@MainActivity,
                        "List returned null",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }


    }

    fun detailClicked() {
        if (searchList.size > 0) {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("plant", searchList[0])
            startActivity(intent)
        } else {
            Toast.makeText(this, "Data not found.", Toast.LENGTH_SHORT).show()
        }

    }


    @SuppressLint("SetTextI18n")
    fun searchClicked() {
        searchList.clear()
        val list = XmlService.plantList.filter {
            it.common.contains(binding.searchView.query.toString())
        }
        searchList.addAll(list)

        binding.tvNumberSearch.text = "Bulunan ${searchList.size}"
    }
}