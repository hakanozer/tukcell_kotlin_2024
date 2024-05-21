package com.sercancelik.vize_3_sercan_celik.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sercancelik.vize_3_sercan_celik.R
import com.sercancelik.vize_3_sercan_celik.extension.loadImageWithGlide
import com.sercancelik.vize_3_sercan_celik.models.User

class UserAdapter(private val context: Context, private var userList: List<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun updateData(newData: List<User>) {
        userList = newData
        notifyDataSetChanged()
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userName: TextView = itemView.findViewById(R.id.textViewName)
        private val bloodGroup: TextView = itemView.findViewById(R.id.textViewBlood)
        private val textViewAge: TextView = itemView.findViewById(R.id.textViewAge)
        private val imageView = itemView.findViewById<ImageView>(R.id.imageView)

        fun bind(user: User) {
            userName.setText("${user.firstName} ${user.lastName}")
            imageView.loadImageWithGlide(user.image)
            bloodGroup.setText(user.bloodGroup)
            bloodGroup.setText(user.bloodGroup)
            textViewAge.setText(user.age.toString())
        }
    }
}
