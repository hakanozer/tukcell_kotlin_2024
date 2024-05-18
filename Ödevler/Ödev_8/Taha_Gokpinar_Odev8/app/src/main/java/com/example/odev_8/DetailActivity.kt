package com.example.odev_8

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.odev_8.databinding.ActivityDetailBinding
import com.example.odev_8.databinding.ActivityMainBinding
import com.example.odev_8.models.Recipe
import com.example.odev_8.models.Recipes

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
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

        val recipe = intent.getSerializableExtra("recipe") as Recipe

        binding.textViewName.text = recipe.name
        binding.textViewIngredients.text = recipe.ingredients.joinToString("\n")
        binding.textViewInstructions.text = recipe.instructions.joinToString("\n")
        binding.textViewCookTime.text = "Cook Time: ${recipe.cookTimeMinutes} min"
        binding.textViewPrepTime.text = "Prep Time: ${recipe.prepTimeMinutes} min"
        binding.textViewServings.text = "Servings: ${recipe.servings}"
        binding.textViewDifficulty.text = "Difficulty: ${recipe.difficulty}"
        binding.textViewCuisine.text = "Cuisine: ${recipe.cuisine}"
        binding.textViewCalories.text = "Calories: ${recipe.caloriesPerServing}"
        binding.textViewTags.text = "Tags: ${recipe.tags.joinToString(", ")}"
    }
}