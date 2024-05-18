package com.works.days_9

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.works.days_9.models.Recipe

class DetayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        val recipe = intent.getSerializableExtra("recipe") as? Recipe

        recipe?.let {
            findViewById<TextView>(R.id.txt_recipe_name).text = "Recipe Name: ${it.name}"
            findViewById<TextView>(R.id.txt_ingredients).text = "Ingredients:\n${it.ingredients.joinToString("\n")}"
            findViewById<TextView>(R.id.txt_instructions).text = "Instructions:\n${it.instructions.joinToString("\n")}"
            findViewById<TextView>(R.id.txt_prep_time).text = "Prep Time: ${it.prepTimeMinutes} minutes"
            findViewById<TextView>(R.id.txt_cook_time).text = "Cook Time: ${it.cookTimeMinutes} minutes"
            findViewById<TextView>(R.id.txt_servings).text = "Servings: ${it.servings}"
            findViewById<TextView>(R.id.txt_difficulty).text = "Difficulty: ${it.difficulty}"
            findViewById<TextView>(R.id.txt_cuisine).text = "Cuisine: ${it.cuisine}"
            findViewById<TextView>(R.id.txt_calories).text = "Calories Per Serving: ${it.caloriesPerServing}"
            findViewById<TextView>(R.id.txt_rating).text = "Rating: ${it.rating}"
            findViewById<TextView>(R.id.txt_review_count).text = "Review Count: ${it.reviewCount}"
            findViewById<TextView>(R.id.txt_user_id).text = "User ID: ${it.userId}"
            findViewById<TextView>(R.id.txt_image).text = "Image: ${it.image}"
            findViewById<TextView>(R.id.txt_tags).text = "Tags: ${it.tags.joinToString(", ")}"
            findViewById<TextView>(R.id.txt_meal_type).text = "Meal Type: ${it.mealType.joinToString(", ")}"
        }

    }
}