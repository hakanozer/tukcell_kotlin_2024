package com.example.vize_3.adaptors

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.vize_3.R
import com.example.vize_3.models.User

class UserAdapter (private val context: Activity, private var arr: List<User>) :
    ArrayAdapter<User>(context, R.layout.user_row, arr) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = context.layoutInflater.inflate(R.layout.user_row, null, true)
        val dt = arr.get(position)

        val r_image = rootView.findViewById<ImageView>(R.id.r_image)
        val r_name = rootView.findViewById<TextView>(R.id.r_name)
        val r_surname = rootView.findViewById<TextView>(R.id.r_surname)
        val r_bloodtype = rootView.findViewById<TextView>(R.id.r_bloodtype)
        val r_age = rootView.findViewById<TextView>(R.id.r_age)

        r_name.text = dt.firstName
        r_surname.text = dt.lastName
        r_bloodtype.text = "Blood Group: " + dt.bloodGroup
        r_age.text = "Age: " + dt.age.toString()

        Glide.with(rootView).load(dt.image).into(r_image)

        return rootView
    }
}