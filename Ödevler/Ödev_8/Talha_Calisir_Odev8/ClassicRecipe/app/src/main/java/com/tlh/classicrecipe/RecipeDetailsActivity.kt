package com.tlh.classicrecipe

import android.content.Context
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.tlh.classicrecipe.model.Recipe

class RecipeDetailsActivity : AppCompatActivity() {

    private lateinit var detailsName: TextView
    private lateinit var detailsInstructions: TextView
    private lateinit var detailsIngredients: TextView
    private lateinit var detailsTags: TextView
    private lateinit var detailsGroup: TextView
    private lateinit var detailsImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)

        val recipeIntent = intent.getSerializableExtra("recipe") as? Recipe



        detailsName = findViewById(R.id.details_name)
        detailsIngredients = findViewById(R.id.details_ingredients)
        detailsInstructions = findViewById(R.id.details_instructions)
        detailsGroup = findViewById(R.id.details_details)
        detailsTags = findViewById(R.id.details_tags)
        detailsImage = findViewById(R.id.details_image)

        Glide.with(this)
            .load(recipeIntent?.image)
            .into(detailsImage)

        detailsName.text = recipeIntent?.name
        detailsIngredients.text = recipeIntent?.ingredients.toString()
        detailsInstructions.text = recipeIntent?.instructions.toString()
        detailsTags.text = recipeIntent?.tags.toString()


        val details = """
        Prep Time: ${recipeIntent?.prepTimeMinutes} minutes
            Cook Time: ${recipeIntent?.cookTimeMinutes} minutes
            Servings: ${recipeIntent?.servings}
            Difficulty: ${recipeIntent?.difficulty}
            Cuisine: ${recipeIntent?.cuisine}
            Calories per Serving: ${recipeIntent?.caloriesPerServing}
            Rating: ${recipeIntent?.rating} (${recipeIntent?.reviewCount} reviews)
        """.trimIndent()

        detailsGroup.text = details


    }
}