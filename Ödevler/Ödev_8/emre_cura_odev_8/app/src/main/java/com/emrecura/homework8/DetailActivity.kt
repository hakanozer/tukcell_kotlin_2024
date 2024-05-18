package com.emrecura.homework8

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.emrecura.homework8.models.Recipe

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val selectedRecipe = intent.getSerializableExtra("selectedRecipe") as Recipe

        val detailRecipeImage = findViewById<ImageView>(R.id.detailRecipeImage)
        val nameDetailText = findViewById<TextView>(R.id.nameDetailText)
        val detailDifficultyText = findViewById<TextView>(R.id.detailDifficultyText)
        val detailDurationText = findViewById<TextView>(R.id.detailDurationText)
        val detailRateText = findViewById<TextView>(R.id.detailRateText)
        val detailIngredients = findViewById<TextView>(R.id.detailIngredients)
        val detailInstructionText = findViewById<TextView>(R.id.detailInstructionText)

        Glide.with(this).load(selectedRecipe.image).into(detailRecipeImage)
        nameDetailText.text = selectedRecipe.name
        detailDifficultyText.text = "Difficulty: ${selectedRecipe.difficulty}"
        detailDurationText.text = "Duration: ${selectedRecipe.prepTimeMinutes} min"
        detailRateText.text = "Rate: ${selectedRecipe.rating}"
        detailIngredients.text = "Ingredients: \n ${selectedRecipe.ingredients.joinToString(", ")}"
        detailInstructionText.text = "Instruction: \n ${selectedRecipe.instructions.joinToString(" ")}"
    }
}