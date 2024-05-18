package com.omersungur.recipeapp_hw8.presentation.recipe_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.omersungur.recipeapp_hw8.R
import com.omersungur.recipeapp_hw8.core.RecipeDifficulty
import com.omersungur.recipeapp_hw8.core.viewBinding
import com.omersungur.recipeapp_hw8.databinding.FragmentRecipeDetailBinding

class RecipeDetailFragment : Fragment(R.layout.fragment_recipe_detail) {

    private val binding by viewBinding(FragmentRecipeDetailBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getRecipesFromRecipeListFragment()
    }

    private fun getRecipesFromRecipeListFragment() {
        val bundle: RecipeDetailFragmentArgs by navArgs()

        bundle.recipeResult.let { recipe ->
            with(binding) {
                Glide.with(requireActivity()).load(recipe.image).into(ivFood)
                tvDetailName.text = getString(R.string.detail_name, recipe.name)
                tvDetailPerTimeMinutes.text = getString(R.string.detail_prep_time_minutes, recipe.prepTimeMinutes)
                tvDetailCookTimeMinutes.text = getString(R.string.detail_cook_time_minutes, recipe.cookTimeMinutes)
                tvDetailServings.text = getString(R.string.detail_servings, recipe.servings)
                tvDetailDifficulty.text = getString(R.string.detail_difficulty, recipe.difficulty)
                tvDetailCuisine.text = getString(R.string.detail_cuisine, recipe.cuisine)
                tvDetailCaloriesPerServing.text = getString(R.string.detail_calories_per_serving, recipe.caloriesPerServing)
                tvDetailRating.text = getString(R.string.detail_rating, recipe.rating)
                tvDetailMealType.text = getString(R.string.detail_meal_type, recipe.mealType.joinToString())
                tvDetailIngredients.text = getString(R.string.detail_ingredients, recipe.ingredients.joinToString("\n-> "))
                tvDetailInstructions.text = getString(R.string.detail_instructions, recipe.instructions.joinToString("\n-> "))

                setRatingStarImage(recipe.rating)
                setDifficultyImage(recipe.difficulty)
            }
        }
    }

    private fun setRatingStarImage(rating: Double) {
        if (rating > 2.5) {
            binding.ivStar.setImageResource(R.drawable.ic_filled_star)
        } else {
            binding.ivStar.setImageResource(R.drawable.ic_outlined_star)
        }
    }

    private fun setDifficultyImage(difficulty: String) {
        when(difficulty) {
            RecipeDifficulty.Easy.toString() -> {
                binding.ivDifficulty.setImageResource(R.drawable.ic_easy_diff)
            }
            RecipeDifficulty.Medium.toString() -> {
                binding.ivDifficulty.setImageResource(R.drawable.ic_medium_diff)
            }
            RecipeDifficulty.Hard.toString() -> {
                binding.ivDifficulty.setImageResource(R.drawable.ic_hard_diff)
            }
        }
    }
}