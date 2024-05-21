package com.example.eray_altilar_vize_3.presentation.home_screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.eray_altilar_vize_3.R
import com.example.eray_altilar_vize_3.domain.model.UsersModel

class UserAdapter(private var users: UsersModel) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgUser: ImageView = view.findViewById(R.id.imgUser)
        val txtName: TextView = view.findViewById(R.id.txtName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_row, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users
        holder.txtName.text = user.users[position].firstName
        Glide.with(holder.imgUser.context).load(user.users[position].image).into(holder.imgUser)
    }

    override fun getItemCount() = users.users.size


}
