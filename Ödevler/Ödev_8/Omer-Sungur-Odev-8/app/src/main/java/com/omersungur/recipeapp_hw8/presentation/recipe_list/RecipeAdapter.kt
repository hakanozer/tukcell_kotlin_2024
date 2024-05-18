package com.omersungur.recipeapp_hw8.presentation.recipe_list

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.omersungur.recipeapp_hw8.R
import com.omersungur.recipeapp_hw8.databinding.RecipeRowBinding
import com.omersungur.recipeapp_hw8.domain.model.RecipeResult

class RecipeAdapter(private val context: Activity, private var recipeList: List<RecipeResult>) :
    ArrayAdapter<RecipeResult>(context, R.layout.recipe_row, recipeList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = RecipeRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        val recipe = recipeList[position]

        with(binding) {
            tvName.text = context.getString(R.string.recipe_name, recipe.name)
            tvCuisine.text = context.getString(R.string.recipe_cuisine, recipe.cuisine)
            tvCaloriesPerServing.text = context.getString(R.string.recipe_calories_per_serving, recipe.caloriesPerServing)

            Glide.with(root).load(recipe.image).into(binding.ivFoodImage)

            lyRecipeRow.setOnClickListener {
                val navigate = RecipeListFragmentDirections.actionRecipeListFragmentToRecipeDetailFragment(recipe)
                Navigation.findNavController(it).navigate(navigate)
            }
        }

        return binding.root
    }
}