package com.tlh.foodrecipe.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.tlh.foodrecipe.databinding.RecyclerRowBinding
import com.tlh.foodrecipe.model.Recipe
import com.tlh.foodrecipe.view.ListFragmentDirections

class RecipeAdapter(val recipeList: List<Recipe>) :
    RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    class RecipeViewHolder(val binding: RecyclerRowBinding) :
        RecyclerView.ViewHolder(binding.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val recyclerRowBinding =
            RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(recyclerRowBinding)
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.binding.textView.text = recipeList[position].recipeName
        holder.itemView.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToRecipeFragment(info = "old", id = recipeList[position].rid)
            Navigation.findNavController(it).navigate(action)

        }
    }
}