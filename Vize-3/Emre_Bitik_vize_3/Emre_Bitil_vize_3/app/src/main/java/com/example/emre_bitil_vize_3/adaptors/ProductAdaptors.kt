package com.example.emre_bitil_vize_3.adaptors

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.emre_bitil_vize_3.R
import com.example.emre_bitil_vize_3.models.User

class ProductAdaptors(private val context: Activity, private var arr: List<User>) :
    ArrayAdapter<User>(context, R.layout.product_row, arr)
{

    @SuppressLint("MissingInflatedId")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = context.layoutInflater.inflate(R.layout.product_row, null, true)
        val dt = arr.get(position)

        val r_image = rootView.findViewById<ImageView>(R.id.r_image)
        val r_name = rootView.findViewById<TextView>(R.id.r_name)
        val r_username = rootView.findViewById<TextView>(R.id.r_username)
        val r_blood = rootView.findViewById<TextView>(R.id.r_blood)


        r_name.setText(dt.firstName+" "+dt.lastName)
        r_username.setText(dt.username)
        r_blood.setText(dt.bloodGroup)
       // r_price.setText("${dt.price}₺")
        Glide.with(context)
            .load(dt.image)
            .centerCrop()
            .into(r_image)
        return rootView
    }

}