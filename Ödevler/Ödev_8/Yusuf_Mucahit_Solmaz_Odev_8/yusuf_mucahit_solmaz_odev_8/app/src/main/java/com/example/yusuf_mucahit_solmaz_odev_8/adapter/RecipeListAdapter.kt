package com.example.yusuf_mucahit_solmaz_odev_8.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.yusuf_mucahit_solmaz_odev_8.RecipeDetailActivity
import com.example.yusuf_mucahit_solmaz_odev_8.data.model.Recipe
import com.example.yusuf_mucahit_solmaz_odev_8.databinding.RecipeRowBinding

class RecipeListAdapter(private val context: Context, private val recipes: List<Recipe>) : BaseAdapter() {

    override fun getCount(): Int = recipes.size

    override fun getItem(position: Int): Any = recipes[position]

    override fun getItemId(position: Int): Long = position.toLong()

    @SuppressLint("SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding: RecipeRowBinding
        val view: View

        if (convertView == null) {
            binding = RecipeRowBinding.inflate(LayoutInflater.from(context), parent, false)
            view = binding.root
            view.tag = binding
        } else {
            view = convertView
            binding = view.tag as RecipeRowBinding
        }

        val recipe = recipes[position]

        binding.apply {
            Glide.with(context)
                .load(recipe.image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(foodImageView)

            foodName.text = recipe.name
            caloriesPerServing.text = "${recipe.caloriesPerServing}kcal"

            recipeCardView.setOnClickListener {
                val intent = Intent(context, RecipeDetailActivity::class.java)
                intent.putExtra("recipe", recipe)
                context.startActivity(intent)
            }
        }

        return view
    }
}
