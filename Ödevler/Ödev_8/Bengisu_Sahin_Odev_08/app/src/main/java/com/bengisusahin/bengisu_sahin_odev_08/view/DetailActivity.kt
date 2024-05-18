package com.bengisusahin.bengisu_sahin_odev_08.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bengisusahin.bengisu_sahin_odev_08.R
import com.bengisusahin.bengisu_sahin_odev_08.databinding.ActivityDetailBinding
import com.bengisusahin.bengisu_sahin_odev_08.models.Recipe
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        val detail = intent.getSerializableExtra("detail") as Recipe
        // Thanks to apply func it accessed all properties of binding.
        binding.apply {
            txtViewName.text = detail.name
            txtViewIngredientsContent.text = detail.ingredients.joinToString(", ")
            txtViewInstructionsContent.text = detail.instructions.joinToString("\n")
            txtViewPrepTimeMinutesContent.text = " ${detail.prepTimeMinutes} minutes"
            txtViewCookTimeMinutesContent.text = " ${detail.cookTimeMinutes} minutes"
            txtViewServingsContent.text = " ${detail.servings}"
            txtViewDifficultyContent.text = " ${detail.difficulty}"
            txtViewCuisineContent.text = " ${detail.cuisine}"
            txtViewCaloriesPerServingContent.text = " ${detail.caloriesPerServing} calories"
            txtViewTagsContent.text = "#${detail.tags.joinToString(", #")}"
            txtViewUserIdContent.text = " ${detail.userId}"
            txtViewRatingContent.text = " ${detail.rating}"
            txtViewReviewCountContent.text = " ${detail.reviewCount}"
            txtViewMealTypeContent.text = " ${detail.mealType.joinToString(", ")}"
            Glide.with(this@DetailActivity)
                .load(detail.image)
                .into(imageViewContent)
        }

    }
}