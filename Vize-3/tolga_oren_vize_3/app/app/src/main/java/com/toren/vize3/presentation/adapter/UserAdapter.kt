package com.toren.vize3.presentation.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.toren.vize3.data.dto.User
import com.toren.vize3.databinding.UserRowBinding
import com.toren.vize3.presentation.activity.MainActivity

class UserAdapter(
    private val userList: MutableList<User>,
    private val clickListener: MainActivity,
) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(val binding: UserRowBinding) :
        RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {
        init {
            binding.root.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                clickListener.onItemClick(position)
            }
        }

    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = UserRowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return UserViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        Glide.with(holder.itemView)
            .load(user.image)
            .into(holder.binding.userImageVw)
        holder.binding.apply {
            userNameTw.text = "${user.firstName} ${user.lastName}"
            ageTw.text = "${user.age} y.o."
            heightTw.text = "${user.height} cm"
            weightTw.text = "${user.weight} kg"
            emailTw.text = user.email
            phoneTw.text = user.phone
            cityTw.text = user.address.city
            stateTw.text = user.address.state
            companyTw.text = user.company.title

        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateUserList(newUserList: List<User>) {
        userList.clear()
        userList.addAll(newUserList)
        notifyDataSetChanged()
    }
}