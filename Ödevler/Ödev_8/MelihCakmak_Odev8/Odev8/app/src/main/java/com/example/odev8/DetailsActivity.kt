package com.example.odev8


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.odev8.databinding.ActivityDetailsBinding
import com.example.odev8.models.Recipe
import com.google.gson.Gson

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

        lateinit var recipe:Recipe

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        val recipeJson = intent.getStringExtra("recipeJson")
        recipe = Gson().fromJson(recipeJson, Recipe::class.java)


        binding.imageView.setImageResource(R.drawable.ic_launcher_foreground)
        binding.txtDetail.setText("Name: ${recipe.name}\n" +
                "Cuisine: ${recipe.cuisine}\n" +
                "Difficulty: ${recipe.difficulty}\n" +
                "Tags: ${recipe.tags.joinToString(separator = ",")}\n" +
                "Servings: ${recipe.servings}\n"
                +"Review Count: ${recipe.reviewCount}\n"
                + "Rating: ${recipe.rating}\n"
                + "Meal Type: ${recipe.mealType.joinToString(separator = ",")}\n"
                + "PrepTimeMinutes: ${recipe.prepTimeMinutes}\n"
                + "CookTimeMinutes: ${recipe.cookTimeMinutes}\n"

        )

        binding.txtIngredients.text = "Ingredients\n"+recipe.ingredients.joinToString(separator = "\n")
        binding.txtInstructions.text = "Instructions\n"+recipe.instructions.joinToString(separator = "\n")





    }
}