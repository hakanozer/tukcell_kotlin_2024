package com.works.days_9.adaptors

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.works.days_9.R
import com.works.days_9.models.Product

class ProductAdaptors(private val context: Activity, private var arr: List<Product>) :
    ArrayAdapter<Product>(context, R.layout.product_row, arr)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = context.layoutInflater.inflate(R.layout.product_row, null, true)
        val dt = arr[position]

        val r_image = rootView.findViewById<ImageView>(R.id.r_image)
        val r_title = rootView.findViewById<TextView>(R.id.r_title)
        val r_price = rootView.findViewById<TextView>(R.id.r_price)
        val r_rating = rootView.findViewById<RatingBar>(R.id.r_rating)
        val width = 100
        val height = 140

        r_title.text = dt.title
        r_price.text = "${dt.price} $"
        r_rating.rating = dt.rating.toFloat()
        Glide.with(context)
            .load(dt.thumbnail)
            .override(width, height)
            .into(r_image)

        return rootView
    }
}