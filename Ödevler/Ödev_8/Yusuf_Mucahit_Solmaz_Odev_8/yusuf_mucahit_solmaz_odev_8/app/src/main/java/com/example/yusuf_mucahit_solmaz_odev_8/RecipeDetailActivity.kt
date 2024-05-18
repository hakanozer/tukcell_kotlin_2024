package com.example.yusuf_mucahit_solmaz_odev_8

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.yusuf_mucahit_solmaz_odev_8.adapter.IngredientsAdapter
import com.example.yusuf_mucahit_solmaz_odev_8.adapter.InstructionsAdapter
import com.example.yusuf_mucahit_solmaz_odev_8.data.model.Recipe
import com.example.yusuf_mucahit_solmaz_odev_8.databinding.ActivityRecipeDetailBinding

class RecipeDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecipeDetailBinding
    private lateinit var recipe: Recipe

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeDetailBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        recipe = intent.getSerializableExtra("recipe") as Recipe

        Log.d("RecipeDetailActivity", "onCreate: $recipe")

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Glide.with(this)
            .load(recipe.image)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.recipeImageView);

        binding.rating.text = recipe.rating.toString()
        binding.foodTitle.text = recipe.name
        binding.calories.text = "${recipe.caloriesPerServing}kcal"
        binding.cookTime.text = "${recipe.cookTimeMinutes}min"
        binding.prepareTime.text = "${recipe.prepTimeMinutes}min"
        binding.servingFor.text = "Serving for ${recipe.servings}"

        val ingredientsAdapter = IngredientsAdapter(this, recipe.ingredients)
        binding.ingredientsListView.adapter = ingredientsAdapter

        val instructionsAdapter = InstructionsAdapter(this, recipe.instructions)
        binding.instructionsListView.adapter = instructionsAdapter
    }
}
