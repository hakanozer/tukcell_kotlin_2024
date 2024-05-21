package com.bengisusahin.vize03_calisma.adapters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bengisusahin.vize03_calisma.databinding.RecyclerRowBinding
import com.bengisusahin.vize03_calisma.models.User
import com.bengisusahin.vize03_calisma.view.DetailActivity
import com.bumptech.glide.Glide

class UserAdapter(var userList : List<User>) : RecyclerView.Adapter<UserAdapter.UserHolder>() {

    //class UserHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    class UserHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindItem(user:User){
            binding.recyclerViewTxtUserName.text = user.username
            Glide.with(binding.root.context)
                .load(user.image)
                .into(binding.rwImageViewUserImage)

            binding.root.setOnClickListener {
                Log.d("bindItem", "onBindViewHolder: click $user")
                val context = it.context
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("userDetail", user)
                context.startActivity(intent)
            }
        }
    }

    // UserHolder da oluşturduğumuz view holder ilk oluşturulduğunda ne olacak
    // layout ile bağlama işlemini yapıyoruz
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserHolder(binding)
    }

    // kaç tane oluşturacağız
    override fun getItemCount(): Int {
        return userList.size
    }

    // layouta bağlandıktan sonra ne olacak
    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bindItem(userList[position])
    }

    fun updateUsersView(newUsers: List<User>) {
        userList = newUsers
        notifyDataSetChanged()
    }
}