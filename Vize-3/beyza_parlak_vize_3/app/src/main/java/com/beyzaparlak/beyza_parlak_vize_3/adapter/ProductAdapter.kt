package com.beyzaparlak.beyza_parlak_vize_3.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.beyzaparlak.beyza_parlak_vize_3.R
import com.beyzaparlak.beyza_parlak_vize_3.modell.UserX
import com.bumptech.glide.Glide

class ProductAdapter(private val context: Activity, private var arr: List<UserX>) :
    ArrayAdapter<UserX>(context, R.layout.product_row, arr)
{

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = context.layoutInflater.inflate(R.layout.product_row, null, true)
        val dt = arr.get(position)

        val r_image = rootView.findViewById<ImageView>(R.id.r_image)
        val r_title = rootView.findViewById<TextView>(R.id.r_title)
        val r_price = rootView.findViewById<TextView>(R.id.r_price)
        val r_blood = rootView.findViewById<TextView>(R.id.r_blood)

        r_title.text = dt.firstName + " " + dt.lastName
        r_price.text = dt.age.toString()
        r_blood.text = dt.bloodGroup


        Glide.with(rootView).load(dt.image).into(r_image)

        return rootView
    }
}