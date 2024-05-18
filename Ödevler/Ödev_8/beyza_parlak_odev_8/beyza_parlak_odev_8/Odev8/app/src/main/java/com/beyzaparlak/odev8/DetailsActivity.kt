package com.beyzaparlak.odev8

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.beyzaparlak.odev8.databinding.ActivityDetailsBinding
import com.beyzaparlak.odev8.models.Recipe
import com.google.gson.Gson

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    lateinit var recipe: Recipe

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val recipeJson = intent.getStringExtra("recipeJson")
        recipe = Gson().fromJson(recipeJson, Recipe::class.java)

        binding.txtName.setText("Name: ${recipe.name}\n" +
                                "Country: ${recipe.cuisine}\n" +
                                "Difficulty: ${recipe.difficulty}\n" +
                                "Review Count: ${recipe.reviewCount}\n"+
                                "Cook Time Minutes: ${recipe.cookTimeMinutes}\n"
        )

        binding.txtRating.text = recipe.rating.toString()

        binding.txtMaterials.text = "MATERIALS\n" +
                                    recipe.ingredients.joinToString(separator = "\n")

        binding.txtRecipe.text = "RECIPE\n" +
                recipe.instructions.joinToString(separator = "\n")
    }
}