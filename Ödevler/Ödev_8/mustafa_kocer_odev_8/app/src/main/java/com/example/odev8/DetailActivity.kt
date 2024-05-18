package com.example.odev8

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.odev8.databinding.ActivityDetailBinding
import com.example.odev8.models.Recipe

class DetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // binding tanımlandı

        // Intent'ten nesneyi alma
        val selected = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("selectedObject", Recipe::class.java)
            // sdk 33 ve üstü için yani 33-34 için
        } else {
            // sdk 33 ve altı için
            @Suppress("DEPRECATION")
            intent.getSerializableExtra("selectedObject") as? Recipe
        }

        selected?.let {
            // verileri eşitleme
            binding.txtName.text = it.name.toString()
            binding.txtCalories.text = "Calories: "+it.caloriesPerServing.toString()
            binding.txtRating.text = "Rating: "+it.rating.toString()
            binding.txtCuisine.text = "Cuisine: "+it.cuisine.toString()
            binding.txtReviewCount.text ="Review Count: "+ it.reviewCount.toString()
            binding.txtPreparingMinute.text="Preparing Minute: "+it.prepTimeMinutes.toString()

            binding.txtDifficulty.text="Difficulty: "+it.difficulty.toString()
            binding.txtServings.text="Servings: "+it.servings.toString()
            binding.txtCookMinute.text="Cook Minute: "+it.cookTimeMinutes.toString()

            var temp = it.mealType.joinToString(separator = ", ")
            binding.txtMealType.text= "Meal Type: "+temp.toString()

            val url = it.image
            Glide.with(this@DetailActivity).load(url).into(binding.imgView)

            temp = it.ingredients.joinToString(separator = ". ")
            binding.txtIngredients.text = "Ingredients: "+temp.toString()

            temp = it.instructions.joinToString(separator = ". ")
            binding.txtInstructions.text = "Instructions: "+temp.toString()

            temp = it.tags.joinToString(separator = ", ")
            binding.txtTags.text= "Tags: "+temp.toString()

        }


    }
}