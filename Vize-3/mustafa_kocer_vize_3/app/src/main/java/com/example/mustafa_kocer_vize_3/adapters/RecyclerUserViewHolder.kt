package com.example.mustafa_kocer_vize_3.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mustafa_kocer_vize_3.R
import com.example.mustafa_kocer_vize_3.models.User
import com.example.mustafa_kocer_vize_3.models.UsersModel

class RecyclerUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindItem(rowModel: User){

        val row_name = itemView.findViewById<TextView>(R.id.row_name)
        val row_blood_group = itemView.findViewById<TextView>(R.id.row_blood_group)

        val row_img = itemView.findViewById<ImageView>(R.id.row_img)
        val url = rowModel.image

        val row_phone = itemView.findViewById<TextView>(R.id.row_phone)
        val row_mail = itemView.findViewById<TextView>(R.id.row_mail)

        row_phone.text = rowModel.phone.toString()
        row_mail.text = rowModel.email.toString()
        Glide.with(itemView.context).load(url).into(row_img)
        // row_img adli imageView'a görüntüleri getiriyorum.

        row_name.text = (rowModel.firstName + " " + rowModel.lastName).toString()
        row_blood_group.text = (rowModel.bloodGroup)

    }

}