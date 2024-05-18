package com.sercancelik.odev_8

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import com.sercancelik.odev_8.configs.ApiClient
import com.sercancelik.odev_8.configs.ImageLoader
import com.sercancelik.odev_8.databinding.ActivityDetailsBinding
import com.sercancelik.odev_8.models.Recipe
import com.sercancelik.odev_8.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        progressBar = binding.progressBar2
        enableEdgeToEdge()
        val recipeId = intent.getLongExtra("recipe_id", 0)
        fetchRecipe(recipeId)
    }

    private fun fetchRecipe(id: Long) {
        progressBar.visibility = ProgressBar.VISIBLE
        val apiService = ApiClient.getClient().create(DummyService::class.java)
        val call = apiService.getRecipe(id)
        call.enqueue(object : Callback<Recipe> {
            override fun onResponse(call: Call<Recipe>, response: Response<Recipe>) {
                if (response.isSuccessful) {
                    val recipe = response.body()
                    if (recipe != null) {
                        updateUI(recipe)
                    }
                } else {
                    Log.e("API_ERROR", "Response was not successful: ${response.message()}")
                }
                progressBar.visibility = ProgressBar.GONE
            }

            override fun onFailure(call: Call<Recipe>, t: Throwable) {
                Log.e("API_ERROR", "Failed to fetch recipe: ${t.message}")
                progressBar.visibility = ProgressBar.GONE
            }
        })
    }

    @SuppressLint("SetTextI18n")
    private fun updateUI(recipe: Recipe) {
        ImageLoader.loadImage(this, recipe.image, binding.imgRecipeDetail)
        binding.collapsingToolbar.title = "${recipe.name} ⭐${recipe.rating}\uD83C\uDF1F"
        binding.ingredients.text =
            "Ingredients: \n${recipe.ingredients.joinToString(separator = ", ")}"
        binding.instructions.text =
            "Instructions: \n${recipe.instructions.joinToString(separator = ", ")}"
        binding.prepTime.text = "${recipe.prepTimeMinutes} min."
        binding.cookTime.text = "${recipe.cookTimeMinutes} min."
        binding.difficultLvl.text = recipe.difficulty
        binding.serving.text = recipe.servings.toString()
        binding.cuisine.text = recipe.cuisine
        binding.kcal.text = recipe.caloriesPerServing.toString() + " kcal"
        binding.tags.text =
            "#${recipe.tags.joinToString(separator = ", #")}"
        binding.reviews.text = recipe.reviewCount.toString()
        binding.mealType.text = recipe.mealType.joinToString(separator = ", ")
    }
}
