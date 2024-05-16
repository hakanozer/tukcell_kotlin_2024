package com.canerdedeoglu.odev_8

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.canerdedeoglu.odev_8.model.Recipe

class DetailActivity : AppCompatActivity() {

    lateinit var  txtName : TextView
    lateinit var txtIngredients : TextView
    lateinit var txtInstructions : TextView
    lateinit var txtDetails : TextView
    lateinit var txtViewTags : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_detail)

        // Recipe nesnesini intent'ten al
        val recipe = intent.getSerializableExtra("recipe") as Recipe

        txtName = findViewById(R.id.txt_name)
        txtIngredients = findViewById(R.id.txt_ingredients)
        txtInstructions = findViewById(R.id.txt_instructions)
        txtDetails = findViewById(R.id.txt_details)
        txtViewTags = findViewById(R.id.txt_tags)

        txtName.text = recipe.name
        txtIngredients.text = "Ingredients: \n" + recipe.ingredients.joinToString("\n")
        txtInstructions.text = "Instructions: \n" + recipe.instructions.joinToString("\n")
        val details = """
            Prep Time: ${recipe.prepTimeMinutes} minutes
            Cook Time: ${recipe.cookTimeMinutes} minutes
            Servings: ${recipe.servings}
            Difficulty: ${recipe.difficulty}
            Cuisine: ${recipe.cuisine}
            Calories per Serving: ${recipe.caloriesPerServing}
            Rating: ${recipe.rating} (${recipe.reviewCount} reviews)
        """.trimIndent()
        txtDetails.text = details
        txtViewTags.text = "Tags: " + recipe.tags.joinToString(", ")
    }
}