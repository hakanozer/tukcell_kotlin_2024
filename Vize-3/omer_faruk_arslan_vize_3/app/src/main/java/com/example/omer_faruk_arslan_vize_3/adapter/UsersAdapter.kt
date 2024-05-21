package com.example.omer_faruk_arslan_vize_3.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.omer_faruk_arslan_vize_3.R
import com.example.omer_faruk_arslan_vize_3.models.User
import com.example.omer_faruk_arslan_vize_3.models.Users

class UserAdapter (private val context : Activity, private val arr : List<User>)
    : ArrayAdapter<User>(context, R.layout.users_row,arr)
{

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val rootView = context.layoutInflater.inflate(R.layout.users_row, null, true)
        val dt = arr.get(position)

        val user_image : ImageView = rootView.findViewById(R.id.user_image)
        val user_name : TextView = rootView.findViewById(R.id.user_name)
        val user_lastName : TextView = rootView.findViewById(R.id.user_lastname)
        val user_gender : TextView = rootView.findViewById(R.id.user_gender)

        user_name.setText(dt.firstName)
        user_lastName.setText(dt.lastName)
        user_gender.setText(dt.gender.toString())

        val url = dt.image
        Glide.with(rootView).load(url).into(user_image)

        return rootView
    }
}