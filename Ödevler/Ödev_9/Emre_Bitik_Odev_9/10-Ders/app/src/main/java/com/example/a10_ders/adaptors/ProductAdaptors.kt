package com.example.a10_ders.adaptors

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.a10_ders.R
import com.example.a10_ders.models.Product
import android.os.Handler

@Suppress("DEPRECATION")
class ProductAdaptors(private val context: Activity, private val arr:List<Product>)
    : ArrayAdapter<Product>(context,R.layout.product_row)
{
    private val selectedPositions = mutableSetOf<Int>()
    override fun getCount(): Int {
        return arr.count()
    }

    @SuppressLint("SuspiciousIndentation")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView =context.layoutInflater.inflate(R.layout.product_row,null,true)

    val dt =arr.get(position)
    val r_image: ImageView = rootView.findViewById(R.id.r_image)
    val r_title: TextView = rootView.findViewById(R.id.r_title)
    val r_price: TextView = rootView.findViewById(R.id.r_price)

        r_title.setText(dt.title)
        r_price.setText("${dt.price}")

        val url = dt.thumbnail
        Glide.with(rootView).load(url).into(r_image)
        if (selectedPositions.contains(position)) {
            rootView.setBackgroundColor(Color.BLUE)
                selectedPositions.remove(position)
                rootView.setBackgroundColor(Color.TRANSPARENT)

        } else {
            rootView.setBackgroundColor(Color.TRANSPARENT)
        }
        rootView.setOnClickListener{
            if (selectedPositions.contains(position)) {
                selectedPositions.remove(position)
                rootView.setBackgroundColor(Color.TRANSPARENT)
            } else {
                selectedPositions.add(position)
                rootView.setBackgroundColor(Color.BLUE)

                    selectedPositions.remove(position)
                    rootView.setBackgroundColor(Color.TRANSPARENT)
            }
            notifyDataSetChanged()

        }
        return rootView
    }


}
