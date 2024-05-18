package com.cevdetkilickeser.odev8

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.cevdetkilickeser.odev8.databinding.ActivityDetailBinding
import com.cevdetkilickeser.odev8.model.Recipe

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recipe = intent.getSerializableExtra("recipe") as Recipe

        val mealType = seperateList(recipe.mealType, ", ")
        val ingredients = "- " + seperateList(recipe.ingredients, "\n- ")
        val instructions = "- " + seperateList(recipe.instructions, "\n\n- ")
        val tags = "#" + seperateList(recipe.tags, "\n#")

        Glide.with(binding.imgRecipeDetail).load(recipe.image).into(binding.imgRecipeDetail)
        binding.txtNameDetail.text = recipe.name
        binding.txtCuisineDetail.text = recipe.cuisine
        binding.txtMealtypeDetail.text = mealType
        binding.txtDififultyDetail.text = recipe.difficulty
        binding.txtRatingDetail.text = recipe.rating.toString()
        binding.txtCaloriDetail.text = recipe.caloriesPerServing.toString() + " Kcal"
        binding.txtReviewDetail.text = recipe.reviewCount.toString()
        binding.txtServiceDetail.text = recipe.servings.toString()
        binding.txtPrepDetail.text = recipe.prepTimeMinutes.toString()
        binding.txtCookDetail.text = recipe.cookTimeMinutes.toString()
        binding.txtIngredDetail.text = ingredients
        binding.txtInstruct.text = instructions
        binding.txtTagDetail.text = tags


    }

    private fun seperateList(list: List<String>, seperator: String): String {
        val seperatedList = list.joinToString(seperator)
        return seperatedList
    }
}