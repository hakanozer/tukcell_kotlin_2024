package com.example.yusuf_mucahit_solmaz_odev_8.repository.serviceImp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.yusuf_mucahit_solmaz_odev_8.data.model.Recipe
import com.example.yusuf_mucahit_solmaz_odev_8.data.model.RootReciepe
import com.example.yusuf_mucahit_solmaz_odev_8.data.retrofit.ApiClient
import com.example.yusuf_mucahit_solmaz_odev_8.data.retrofit.ApiService
import com.example.yusuf_mucahit_solmaz_odev_8.repository.service.RecipeService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipeServiceImp : RecipeService {

    private lateinit var recipeService: ApiService

    private val _recipeList = MutableLiveData<RootReciepe>()
    val recipeList: LiveData<RootReciepe> = _recipeList

    override fun getAllRecipe() {
        CoroutineScope(Dispatchers.IO).launch {

        }

        recipeService = ApiClient.getClient().create(ApiService::class.java)

        recipeService.getProducts().enqueue(object : Callback<RootReciepe> {
            override fun onResponse(call: Call<RootReciepe>, response: Response<RootReciepe>) {
                if (response.isSuccessful) {

                    _recipeList.value = response.body()

                    Log.d("recipe", recipeList.toString())
                }
            }

            override fun onFailure(p0: Call<RootReciepe>, p1: Throwable) {
                Log.e("getProducts", p1.message!! )
            }
        } )
    }
}