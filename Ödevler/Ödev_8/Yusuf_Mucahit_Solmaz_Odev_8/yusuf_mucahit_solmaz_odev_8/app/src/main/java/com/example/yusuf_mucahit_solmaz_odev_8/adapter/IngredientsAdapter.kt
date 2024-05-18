package com.example.yusuf_mucahit_solmaz_odev_8.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.yusuf_mucahit_solmaz_odev_8.R

class IngredientsAdapter(context: Context, private val ingredients: List<String>) : ArrayAdapter<String>(context, 0, ingredients) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.ingredients_row, parent, false)
        val ingredient = getItem(position)
        val ingredientItemTextView = view.findViewById<TextView>(R.id.ingredientsItem)
        ingredientItemTextView.text = ingredient
        return view
    }
}
