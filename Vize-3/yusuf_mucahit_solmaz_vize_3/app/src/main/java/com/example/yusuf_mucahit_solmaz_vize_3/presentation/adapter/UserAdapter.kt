package com.example.yusuf_mucahit_solmaz_vize_3.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yusuf_mucahit_solmaz_vize_3.R
import com.example.yusuf_mucahit_solmaz_vize_3.data.remote.entity.UserX
import com.example.yusuf_mucahit_solmaz_vize_3.databinding.RecyclerViewRowBinding

class UserAdapter(private val userList: List<UserX>,private val context: Context) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_row, parent, false)
        return UserViewHolder(RecyclerViewRowBinding.bind(itemView))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]

       holder.binding.LastName
        holder.binding.apply {
            txtUserName.text = user.firstName
            age.text = user.age.toString()
            gender.text = user.gender
            LastName.text = user.lastName
            bloodGroup.text = user.bloodGroup

            Glide.with(context)
                .load(user.image)
                .into(holder.binding.imageView)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }


    inner class UserViewHolder(val binding: RecyclerViewRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

}
