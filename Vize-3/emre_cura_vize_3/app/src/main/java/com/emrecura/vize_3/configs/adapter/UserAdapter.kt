package com.emrecura.vize_3.configs.adapter

import android.app.Activity
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.emrecura.vize_3.R
import com.emrecura.vize_3.models.User
import com.emrecura.vize_3.models.Users


class UserAdapter(private val context: Activity, private var arr: List<User>) :
    ArrayAdapter<User>(context, R.layout.user_row, arr)
{

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = context.layoutInflater.inflate(R.layout.user_row, null, true)
        val dt = arr.get(position)

        val r_image = rootView.findViewById<ImageView>(R.id.userImage)
        val r_name = rootView.findViewById<TextView>(R.id.userName)
        val r_gender = rootView.findViewById<TextView>(R.id.userGender)
        val r_birthday = rootView.findViewById<TextView>(R.id.birthdayText)
        val r_blood = rootView.findViewById<TextView>(R.id.bloodText)



        r_name.text = "${dt.firstName} ${dt.lastName}"
        r_birthday.text = dt.birthDate
        r_gender.text = "Gender: ${dt.gender}"
        r_blood.text = "Kan Grubu: ${dt.bloodGroup}"
        Glide.with(rootView).load(dt.image).into(r_image)

        return rootView
    }
}