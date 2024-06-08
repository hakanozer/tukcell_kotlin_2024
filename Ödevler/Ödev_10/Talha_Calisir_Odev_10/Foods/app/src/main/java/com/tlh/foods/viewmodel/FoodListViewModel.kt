package com.tlh.foods.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tlh.foods.model.Food
import com.tlh.foods.roomdb.FoodDatabase
import com.tlh.foods.service.FoodAPIService
import com.tlh.foods.util.PrivateSharedPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FoodListViewModel(application: Application) : AndroidViewModel(application) {
    val foods = MutableLiveData<List<Food>>()
    val foodErrorMessage = MutableLiveData<Boolean>()
    val foodLoading = MutableLiveData<Boolean>()
    private var updatedTime = 10 * 60 * 1000 * 1000 * 1000L

    private val foodApiService = FoodAPIService()
    private val privateSharedPreferences = PrivateSharedPreferences(getApplication())

    fun refreshData() {

        val savedTime = privateSharedPreferences.takeTheTime()
        if (savedTime != null && savedTime != 0L && System.nanoTime() - savedTime < updatedTime) {
            takeDatasFromRoom()
        } else {
            takeDatasFromNet()
        }
    }

    fun refreshFromInternet() {
        takeDatasFromNet()
    }

    private fun takeDatasFromRoom() {
        foodLoading.value = true

        viewModelScope.launch {

            val foodList = FoodDatabase(getApplication()).foodDao().getAllFood()
            showFoods(foodList)
            Toast.makeText(getApplication(), "We took the foods from database", Toast.LENGTH_LONG)
                .show()

        }

    }

    private fun takeDatasFromNet() {
        foodLoading.value = true

        viewModelScope.launch(Dispatchers.IO) {
            val foods = foodApiService.getData()
            withContext(Dispatchers.Main) {
                foodLoading.value = false
                saveInSql(foods)
                Toast.makeText(getApplication(), "We took the datas from net", Toast.LENGTH_LONG)
                    .show()
            }
        }


    }

    private fun showFoods(foodList: List<Food>) {
        foods.value = foodList
        foodErrorMessage.value = false
        foodLoading.value = false
    }

    private fun saveInSql(foodList: List<Food>) {

        viewModelScope.launch {

            val dao = FoodDatabase(getApplication()).foodDao()
            dao.deleteAllFood()
            val uuidList = dao.insertAll(*foodList.toTypedArray())
            var i = 0
            while (i < foodList.size) {
                foodList[i].uuid = uuidList[i].toInt()
                i = i + 1
            }
            showFoods(foodList)
        }

        privateSharedPreferences.saveTheTime(System.nanoTime())

    }

}