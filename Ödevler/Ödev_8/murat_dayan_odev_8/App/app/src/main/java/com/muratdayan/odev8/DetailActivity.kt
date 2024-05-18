package com.muratdayan.odev8

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.muratdayan.odev8.databinding.ActivityDetailBinding
import com.muratdayan.odev8.models.Recipe
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // adapterdan dönen recipe nesnesini aldık
        val recipe = intent.getSerializableExtra("recipe") as? Recipe

        recipe?.let {
            //Log.d("recipeDetail", it.name)

            // apiden dönen resim url'ini kullanarak picasso kütüphanesi sayesinde uygulamamızda gösterdik
            Picasso.get()
                .load(recipe.image)
                .into(binding.imgViewRecipe)

            // verileri detay sayfasındaki bileşenlere ekleme işlemleri
            binding.txtRecipeName.setText(it.name)
            binding.txtRecipeIngredients.text = it.ingredients.joinToString(",").replace(",", "\n")
            binding.txtRecipeInstructions.setText(it.instructions.joinToString(",").replace(",", "\n"))
            binding.txtRecipeTags.setText("Tags: ${it.tags.joinToString(",")}")
            binding.txtRecipeRating.setText(it.rating.toString())
            binding.txtRecipeMealType.setText("Meal Type: ${it.mealType.joinToString(",")}")
            binding.txtCookingTime.setText("${it.cookTimeMinutes}min")
            binding.txtPrepTime.setText("${it.prepTimeMinutes}min")
            binding.txtCaloriesPerSaving.setText("Calory:${it.caloriesPerServing}")
            binding.txtDifficulty.setText("Difficulty: ${it.difficulty}")
            binding.txtCuisine.setText("Cuisine : ${it.cuisine}")
            binding.txtServings.setText("Servings: ${it.servings}")
            binding.txtReviewCount.setText("Review count: ${it.reviewCount}")

        }

        // içindekiler ve talimatlar kısmı için textview'ların visibility kontrolü ve icon değişimi
        binding.cardViewIngredients.setOnClickListener {
            if (binding.txtRecipeIngredients.visibility == View.VISIBLE) {
                binding.txtRecipeIngredients.visibility = View.GONE
                binding.imgIngredientsArrow.setImageResource(R.drawable.ic_drop_down)
            } else {
                binding.txtRecipeIngredients.visibility = View.VISIBLE
                binding.imgIngredientsArrow.setImageResource(R.drawable.ic_drow_up)
            }
        }
        binding.cardViewInstructions.setOnClickListener {
            if (binding.txtRecipeInstructions.visibility == View.VISIBLE) {
                binding.txtRecipeInstructions.visibility = View.GONE
                binding.imgInstructionsArrow.setImageResource(R.drawable.ic_drop_down)
            } else {
                binding.txtRecipeInstructions.visibility = View.VISIBLE
                binding.imgInstructionsArrow.setImageResource(R.drawable.ic_drow_up)
            }
        }







    }
}