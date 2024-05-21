package com.example.melihcakmak_vize3.adaptors

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.melihcakmak_vize3.FilterScreen
import com.example.melihcakmak_vize3.R
import com.example.melihcakmak_vize3.models.User

class ProductAdaptors(private val context: Activity, private var arr: List<User>) :
    ArrayAdapter<User>(context, R.layout.user_row, arr)
{

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = context.layoutInflater.inflate(R.layout.user_row, null, true)
        val dt = arr.get(position)

        val r_image = rootView.findViewById<ImageView>(R.id.r_image)
        val r_firstName = rootView.findViewById<TextView>(R.id.r_firstName)
        val r_id = rootView.findViewById<TextView>(R.id.r_id)

        r_firstName.setText(dt.firstName)
        r_id.setText("${dt.age}")

        val url = dt.image
        Glide.with(rootView).load(url).into(r_image)

        Log.d("this", "row call")

        return rootView
    }}

