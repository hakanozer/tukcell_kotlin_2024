package com.example.yunusemreceylan_odev8.ui.main

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.yunusemreceylan_odev8.R
import com.example.yunusemreceylan_odev8.data.model.Recipe
import com.example.yunusemreceylan_odev8.ui.detail.DetailActivity
import android.widget.LinearLayout as LinearLayout1

class ListAdapter(private val context: Activity, private val array: List<Recipe>) : ArrayAdapter<Recipe>(context, R.layout.row, array) {
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = context.layoutInflater.inflate(R.layout.row, parent, false)
        val data = array[position]

        val r_name: TextView = rootView.findViewById(R.id.r_name)
        val r_caloriesPer: TextView = rootView.findViewById(R.id.r_caloriesPer)
        val r_image: ImageView = rootView.findViewById(R.id.r_image)
        val btnDetay: LinearLayout1 = rootView.findViewById(R.id.row)

        r_name.text = data.name
        r_caloriesPer.text = data.caloriesPerServing.toString()
        Glide.with(context)
            .load(data.image)
            .into(r_image)

        btnDetay.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java).apply {
                putExtra("recipe", data)
            }
            context.startActivity(intent)
        }
        return rootView
    }
}
