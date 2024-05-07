package com.omersungur.omer_sungur_vize_2.view

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.omersungur.omer_sungur_vize_2.R
import com.omersungur.omer_sungur_vize_2.common.Constants.NO_DATA_FOUND
import com.omersungur.omer_sungur_vize_2.common.Constants.NO_ITEM_FOUND
import com.omersungur.omer_sungur_vize_2.common.Constants.PLANT_KEY
import com.omersungur.omer_sungur_vize_2.common.customToast
import com.omersungur.omer_sungur_vize_2.databinding.ActivityMainBinding
import com.omersungur.omer_sungur_vize_2.model.Plant
import com.omersungur.omer_sungur_vize_2.service.XmlService

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var plantList: List<Plant>
    private val foundedPlantList: MutableList<Plant?> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        getDataFromService()

        binding.btnSearch.setOnClickListener {
            searchPlant()
            hideKeyboard(this)
        }

        binding.btnShowDetail.setOnClickListener {
            intentFromMainActivityToDetailActivity()
        }

        binding.tvFollowUs.setOnClickListener {
            showPopUp(it)
        }
    }

    private fun getDataFromService() {
        val xmlService = XmlService()
        Thread {
            plantList = xmlService.getData()
        }.start()
    }

    @SuppressLint("SetTextI18n")
    private fun searchPlant() {
        foundedPlantList.clear() // If this list is already full, then clear it.
        var foundedItemCount = 0
        val searchText = binding.etSearch.text.toString()

        plantList.forEach { plant ->
            if (plant.common.contains(searchText, ignoreCase = false)) {
                foundedItemCount++
                foundedPlantList.add(plant)
            }
        }

        if (foundedItemCount > 0) {
            binding.tvFoundItem.text = "Founded Item: $foundedItemCount"
            binding.tvFoundedPlants.text =
                foundedPlantList.joinToString { it?.common ?: NO_DATA_FOUND }
        } else {
            binding.tvFoundItem.text = NO_ITEM_FOUND
            binding.tvFoundedPlants.text = NO_ITEM_FOUND
        }
    }

    private fun intentFromMainActivityToDetailActivity() {
        if (foundedPlantList.isNotEmpty()) {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(PLANT_KEY, foundedPlantList[0])
            startActivity(intent)
        } else {
            Toast.makeText(this, NO_DATA_FOUND, Toast.LENGTH_SHORT).show()
        }
    }

    private fun showPopUp(view: View) {
        val popUp = PopupMenu(this, view)
        popUp.menuInflater.inflate(R.menu.menu, popUp.menu)
        popUp.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.item_google -> {
                    customToast("Clicked Google!")
                    true
                }

                R.id.item_instagram -> {
                    customToast("Clicked Instagram!")
                    true
                }

                R.id.item_facebook -> {
                    customToast("Clicked Facebook!")
                    true
                }

                else -> false
            }
        }
        popUp.show()
    }

    private fun hideKeyboard(activity: Activity) {
        val inputMethodManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val currentFocusedView = activity.currentFocus
        if (currentFocusedView != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocusedView.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }
}
