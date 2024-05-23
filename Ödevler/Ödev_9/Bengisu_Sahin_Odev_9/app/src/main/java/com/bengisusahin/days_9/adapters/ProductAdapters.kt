package com.bengisusahin.days_9.adapters

import Product
import android.app.Activity
import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bengisusahin.days_9.R
import com.bumptech.glide.Glide

class ProductAdapters(private val context:Activity, private var arr: MutableList<Product>) :
    ArrayAdapter<Product>(context, R.layout.product_row, arr)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = context.layoutInflater.inflate(R.layout.product_row, null, true)
        val dt = arr[position]


        val rTitle= rootView.findViewById<TextView>(R.id.r_title)
        val rImage= rootView.findViewById<ImageView>(R.id.r_image)
        val rPrice= rootView.findViewById<TextView>(R.id.r_price)


        rTitle.text = dt.title
        rPrice.text = "${dt.price}₺"

        val url = dt.thumbnail
        Glide.with(rootView).load(url). into(rImage)

        return rootView
    }
}