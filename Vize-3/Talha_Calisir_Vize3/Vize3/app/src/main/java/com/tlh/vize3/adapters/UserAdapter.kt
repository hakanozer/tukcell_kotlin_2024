package com.tlh.vize3.adapters

import android.annotation.SuppressLint
import android.util.Log
import com.tlh.vize3.models.User

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tlh.vize3.databinding.ItemUserBinding


class UserAdapter(private var users: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.binding.apply {
            textViewFirstName.text = user.firstName
            textViewLastName.text = user.lastName
            textViewAge.text = user.age.toString()
            textViewBloodGroup.text = user.bloodGroup
            Log.d("UserAdapter", "onbindview data: $users")
        }
    }

    override fun getItemCount(): Int = users.size


    fun updateData(newUsers: List<User>) {
        users = newUsers
        notifyDataSetChanged()
        Log.d("UserAdapter", "Updated data: $users")
    }
}
