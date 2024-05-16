package com.canerdedeoglu.odev_8.adaptors

import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import com.canerdedeoglu.odev_8.DetailActivity
import com.canerdedeoglu.odev_8.R
import com.canerdedeoglu.odev_8.model.Recipe

class RecipeAdaptors(private val context:Activity, private val array : List<Recipe>)
    : ArrayAdapter<Recipe>(context, R.layout.recipes_row, array)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val rootView = context.layoutInflater.inflate(R.layout.recipes_row, null,true)
        val data = array.get(position)

        val r_name : TextView = rootView.findViewById(R.id.r_name)
        val r_caloriesPer : TextView = rootView.findViewById(R.id.r_caloriesPer)
        val btnDetay : Button = rootView.findViewById(R.id.btnDetay)

        r_name.setText(data.name)
        r_caloriesPer.setText(data.caloriesPerServing.toString())

        btnDetay.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java).apply {
                putExtra("recipe", data)
            }
            context.startActivity(intent)
        }
        return rootView
    }


}