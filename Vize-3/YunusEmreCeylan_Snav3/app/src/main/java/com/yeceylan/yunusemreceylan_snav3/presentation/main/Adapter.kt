package com.yeceylan.yunusemreceylan_snav3.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yeceylan.yunusemreceylan_snav3.R
import com.yeceylan.yunusemreceylan_snav3.data.model.User

class UserAdapter(private var userList: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userNameTextView: TextView = itemView.findViewById(R.id.id_name)
        private val userEmailTextView: TextView = itemView.findViewById(R.id.hair)
        private val userAgeTextView: TextView = itemView.findViewById(R.id.age)
        private val userGenderTextView: TextView = itemView.findViewById(R.id.gender)
        private val userPhoneTextView: TextView = itemView.findViewById(R.id.id_phone)
        private val userBirthTextView: TextView = itemView.findViewById(R.id.bithDate)
        private val userBloodTextView: TextView = itemView.findViewById(R.id.bloodGroup)
        private val userImageView: ImageView = itemView.findViewById(R.id.id_photo)

        fun bind(user: User) {
            userNameTextView.text = "${user.firstName} ${user.lastName}"
            userEmailTextView.text = "${user.hair.type} and ${user.hair.color}"
            userAgeTextView.text = user.age.toString()
            userGenderTextView.text = user.gender
            userPhoneTextView.text = user.phone
            userBirthTextView.text = user.birthDate
            userBloodTextView.text = user.bloodGroup

            Glide.with(itemView)
                .load(user.image)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(userImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = userList[position]
        holder.bind(currentUser)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun updateUsers(users: List<User>) {
        userList = users
        notifyDataSetChanged()
    }
}