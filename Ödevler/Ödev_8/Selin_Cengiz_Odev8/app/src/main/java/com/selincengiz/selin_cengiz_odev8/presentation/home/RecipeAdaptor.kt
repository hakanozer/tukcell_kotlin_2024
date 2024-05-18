package com.selincengiz.selin_cengiz_odev8.presentation.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.selincengiz.selin_cengiz_odev8.R
import com.selincengiz.selin_cengiz_odev8.common.Extensions.loadUrl
import com.selincengiz.selin_cengiz_odev8.data.entities.Recipe
import com.selincengiz.selin_cengiz_odev8.databinding.ItemFoodBinding
import com.selincengiz.selin_cengiz_odev8.domain.entities.RecipeUI

class RecipeAdaptor(
    private val itemListener: ItemRecipeUIListener,
    private val context: Context,
    private var arr: List<RecipeUI>
) :
    ArrayAdapter<RecipeUI>(context, R.layout.item_food, arr) {

    @SuppressLint("ViewHolder", "SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemFoodBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        val dt = arr[position]

        with(binding) {
            root.setOnClickListener {
                itemListener.onClicked(dt)
            }
            tvRating.text = dt.rating.toString()
            ivFood.loadUrl(dt.image)
            tvTitleFood.text = dt.name
            tvCalories.text = "Calories: " + dt.caloriesPerServing.toString()
        }
        return binding.root
    }

}

interface ItemRecipeUIListener {
    fun onClicked(recipe: RecipeUI)
}