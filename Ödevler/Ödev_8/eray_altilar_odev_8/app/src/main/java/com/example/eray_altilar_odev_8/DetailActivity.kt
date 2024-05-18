package com.example.eray_altilar_odev_8

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.eray_altilar_odev_8.databinding.ActivityDetailBinding
import com.example.eray_altilar_odev_8.model.Recipe
import com.google.gson.Gson

class DetailActivity : AppCompatActivity() {

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

        // Intent'ten Recipe nesnesini al
        val recipeJson = intent.getStringExtra("recipe")
        val clickedRecipe = Gson().fromJson(recipeJson, Recipe::class.java)

        // Recipe resmini yükle
        Glide.with(this)
            .load(clickedRecipe.image)
            .into(binding.imgDetail)

        binding.txtDetailName.text =  clickedRecipe.name
        binding.txtDetailIngredients.text = clickedRecipe.ingredients.joinToString( separator = ", ")
        binding.txtDetailInstructions.text = clickedRecipe.ingredients.joinToString( separator = ", ")
        binding.txtDetailPrepTimeMinutes.text = clickedRecipe.prepTimeMinutes.toString()
        binding.txtDetailCookTimeMinutes.text = clickedRecipe.cookTimeMinutes.toString()
        binding.txtDetailServings.text = clickedRecipe.servings.toString()
        binding.txtDetailDifficulty.text = clickedRecipe.difficulty
        binding.txtDetailCuisine.text = clickedRecipe.cuisine
        binding.txtDetailCaloriesPerServing.text = clickedRecipe.caloriesPerServing.toString()

    }
}