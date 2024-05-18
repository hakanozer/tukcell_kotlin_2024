package com.example.yunusemreceylan_odev8.ui.detail

import android.os.Build
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.yunusemreceylan_odev8.R
import com.example.yunusemreceylan_odev8.data.model.Difficulty
import com.example.yunusemreceylan_odev8.data.model.Recipe
import com.example.yunusemreceylan_odev8.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recipe = intent.getSerializableExtra("recipe", Recipe::class.java)

        recipe?.let {
            bindRecipeDetails(it)
            createIngredientCards(it)
            createTagCards(it)
        }

    }

    private fun bindRecipeDetails(recipe: Recipe) {
        binding.apply {
            txtName.text = recipe.name
            txtInstructions.text = recipe.instructions?.joinToString("\n")
                ?: getString(R.string.placeholder_null)
            val details = """
            ${getString(R.string.label_prep_time)} ${recipe.prepTimeMinutes} ${getString(R.string.label_minutes)}
            ${getString(R.string.label_cook_time)} ${recipe.cookTimeMinutes} ${getString(R.string.label_minutes)}
            ${getString(R.string.label_servings)} ${recipe.servings}
            ${getString(R.string.label_difficulty)} ${recipe.difficulty ?: Difficulty.EASY}
            ${getString(R.string.label_cuisine)} ${recipe.cuisine}
            ${getString(R.string.label_calories_per_serving)} ${recipe.caloriesPerServing}
            ${getString(R.string.label_rating)} ${recipe.rating} (${recipe.reviewCount} ${
                getString(R.string.label_reviews)
            })
        """.trimIndent()
            txtDetails.text = details
            Glide.with(root)
                .load(recipe.image)
                .into(rImage)
        }
    }

    private fun createIngredientCards(recipe: Recipe) {
        val ingredientContainer = findViewById<LinearLayout>(R.id.container)
        recipe.ingredients?.forEach { ingredient ->
            val cardView = createCardView(ingredient)
            ingredientContainer.addView(cardView)
        }
    }

    private fun createTagCards(recipe: Recipe) {
        val tagContainer = findViewById<LinearLayout>(R.id.tagContainer)
        recipe.tags?.forEach { tag ->
            val cardView = createCardView(tag)
            cardView.setCardBackgroundColor(ContextCompat.getColor(this, R.color.greenLight))
            tagContainer.addView(cardView)
        }
    }

    private fun createCardView(text: String): CardView {
        val cardView = CardView(this@DetailActivity)
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(0, 16, 16, 0)
        cardView.layoutParams = layoutParams
        cardView.radius = 16f
        cardView.cardElevation = 8f

        val textView = TextView(this@DetailActivity)
        textView.text = text
        textView.setPadding(16, 16, 16, 16)

        cardView.addView(textView)

        return cardView
    }
}
