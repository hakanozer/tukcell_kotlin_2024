package com.toren.odev8.ui.activity

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import com.bumptech.glide.Glide
import com.toren.odev8.R
import com.toren.odev8.model.Recipe
import com.toren.odev8.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.detailToolbar.toolbarIcon.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.ic_back))
        binding.detailToolbar.toolbarIcon.setOnClickListener {
            finish()
        }

        val arg = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("recipe", Recipe::class.java)
        } else {
            intent.getSerializableExtra("recipe") as Recipe
        }
        arg?.let {
            loadRecipeDetails(it)
        }

    }

    private fun loadRecipeDetails(recipe: Recipe) {
        binding.apply {
            detailToolbar.toolbarTitle.text = recipe.name
            Glide.with(this@DetailActivity).load(recipe.image).into(recipeImgV)
            ratingTw.text = recipe.rating.toString()
            difficultyTw.text = recipe.difficulty
            mealTypeTw.text = recipe.mealType.joinToString(", ")
            cuisineTw.text = recipe.cuisine
            prepTimeTw.text = "${recipe.prepTimeMinutes}  min"
            cookTimeTw.text = "${recipe.prepTimeMinutes} min"
            servingsTw.text = recipe.servings.toString()
            caloriesTw.text = "${recipe.caloriesPerServing} kcal"
            ingredientsTw.text = recipe.ingredients.joinToString(", ")
            instructionsTw.text = recipe.instructions.joinToString("\n")
            tagsTw.text = recipe.tags.joinToString(" ") {"#$it"}
        }
    }
}