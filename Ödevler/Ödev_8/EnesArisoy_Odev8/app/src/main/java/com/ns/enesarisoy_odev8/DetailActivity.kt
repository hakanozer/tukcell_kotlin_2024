package com.ns.enesarisoy_odev8

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.chip.Chip
import com.ns.enesarisoy_odev8.configs.ApiClient
import com.ns.enesarisoy_odev8.databinding.ActivityDetailBinding
import com.ns.enesarisoy_odev8.model.Recipe
import com.ns.enesarisoy_odev8.services.RecipeService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {

    private lateinit var recipeService: RecipeService
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recipeId = intent.getIntExtra("recipeId", 0)

        recipeService = ApiClient.getClient().create(RecipeService::class.java)
        recipeService.getRecipe(recipeId).enqueue(object : Callback<Recipe> {
            override fun onResponse(call: Call<Recipe>, response: Response<Recipe>) {
                if (response.isSuccessful) {
                    val recipe = response.body()
                    setData(recipe!!)
                    println(recipe)
                }
            }

            override fun onFailure(call: Call<Recipe>, t: Throwable) {
                t.printStackTrace()
            }
        })


    }

    private fun setData(recipe: Recipe) {
        binding.apply {
            tvRecipeName.text = recipe.name
            tvCookTime.text = "${recipe.cookTimeMinutes + recipe.prepTimeMinutes} min"
            val ingredientsWithBullet = recipe.ingredients.map { "• $it" }
            tvIngredientsList.text = ingredientsWithBullet.joinToString("\n\n")

            val instructionsWithNumber = recipe.instructions.mapIndexed { index, s -> "${index + 1}. $s" }
            tvInstructionsList.text = instructionsWithNumber.joinToString("\n\n")

            tvStar.text = "${recipe.rating}/5"
            tvDifficulty.text = recipe.difficulty
            tvMealType.text = "for  ${recipe.mealType.joinToString(", ")}"

            val tags = recipe.tags

            for (tag in tags) {
                val chip = Chip(this@DetailActivity)
                chip.text = tag
                chip.isClickable = true
                chip.isCheckable = false
                chip.setChipBackgroundColorResource(R.color.chip_background_color)
                chip.setTextColor(ContextCompat.getColor(this@DetailActivity, R.color.chip_text_color))

                chipGroup.addView(chip)
            }
        }
    }
}