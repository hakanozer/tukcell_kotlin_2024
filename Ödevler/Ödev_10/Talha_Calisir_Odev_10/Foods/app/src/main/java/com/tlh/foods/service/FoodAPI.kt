package com.tlh.foods.service

import com.tlh.foods.model.Food
import retrofit2.http.GET


interface FoodAPI {
    @GET("atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json")
    suspend fun getFood() : List<Food>

}