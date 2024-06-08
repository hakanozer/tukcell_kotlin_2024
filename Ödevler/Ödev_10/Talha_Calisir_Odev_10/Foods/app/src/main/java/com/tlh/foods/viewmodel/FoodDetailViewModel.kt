package com.tlh.foods.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tlh.foods.model.Food
import com.tlh.foods.roomdb.FoodDatabase
import kotlinx.coroutines.launch

class FoodDetailViewModel(application: Application): AndroidViewModel(application) {

    val foodLiveData = MutableLiveData<Food>()

    fun takeRoomData(uuid : Int){
        viewModelScope.launch {
            val dao = FoodDatabase(getApplication()).foodDao()
            val food = dao.getFood(uuid)
            foodLiveData.value = food
        }
    }
}