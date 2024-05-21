package com.umutyusufcinar.vize3app.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.umutyusufcinar.vize3app.R
import com.umutyusufcinar.vize3app.model.UserX

class ProductAdapter(private val context: Activity, private var arr: List<UserX>) :
    ArrayAdapter<UserX>(context, R.layout.product_row, arr)
{

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = context.layoutInflater.inflate(R.layout.product_row, null, true)
        val dt = arr.get(position)

        val r_image = rootView.findViewById<ImageView>(R.id.r_image)
        val r_title = rootView.findViewById<TextView>(R.id.r_title)
        val r_price = rootView.findViewById<TextView>(R.id.r_price)
        val r_lastName = rootView.findViewById<TextView>(R.id.r_lastname)

        r_title.text = dt.firstName
        r_price.text = dt.birthDate
        r_lastName.text = dt.lastName


        Glide.with(rootView).load(dt.image).into(r_image)

        return rootView
    }
}