package com.mai.maidebeyzabulbul_odev_8

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mai.maidebeyzabulbul_odev_8.models.RecipeElement

@Suppress("DEPRECATION")
class RecipeDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recipe_detail)

        val recipe = intent.getSerializableExtra("RECIPE") as? RecipeElement

        findViewById<TextView>(R.id.nameTextView).text = recipe?.name
        findViewById<TextView>(R.id.caloriesTextView).text = "Calories: ${recipe?.caloriesPerServing}"
        findViewById<TextView>(R.id.ingredientsTextView).text = "Ingredients: ${recipe?.ingredients?.joinToString(", ")}"
        findViewById<TextView>(R.id.instructionsTextView).text = "Instructions: ${recipe?.instructions?.joinToString("\n")}"
        findViewById<TextView>(R.id.cuisineTextView).text = "Cuisine: ${recipe?.cuisine}"
        findViewById<TextView>(R.id.difficultyTextView).text = "Difficulty: ${recipe?.difficulty}"
    }

    }
