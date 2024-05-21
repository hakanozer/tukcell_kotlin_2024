package com.ns.enesarisoy_vize3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ns.enesarisoy_vize3.databinding.ItemLoadingBinding
import com.ns.enesarisoy_vize3.databinding.ItemUserBinding
import com.ns.enesarisoy_vize3.model.User

class UserAdapter(
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_ITEM = 0
    private val VIEW_TYPE_LOADING = 1

    private val users = mutableListOf<User>()

    inner class LoadingViewHolder(private val binding: ItemLoadingBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class UserViewHolder(val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.apply {
                tvUserName.text = user.firstName
                Glide.with(root.context)
                    .load(user.image)
                    .into(ivUserImage)
                tvAddress.text = user.address?.address

                binding.root.setOnClickListener {
                    onItemClickListener?.let { it(user) }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_ITEM) {
            val binding =
                ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            UserViewHolder(binding)
        } else {
            val binding =
                ItemLoadingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            LoadingViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is UserViewHolder) {
            holder.bind(users[position])
        }

    }

    override fun getItemCount(): Int = users.size

    override fun getItemViewType(position: Int): Int {
        return if (users[position].isLoading) VIEW_TYPE_LOADING else VIEW_TYPE_ITEM
    }

    fun clearUsers() {
        users.clear()
        notifyDataSetChanged()
    }

    fun setUsers(newUsers: List<User>) {
        val startPosition = users.size
        users.addAll(newUsers)
        notifyItemRangeInserted(startPosition, newUsers.size)
    }

    fun addLoadingFooter() {
        users.add(User(isLoading = true))
        notifyItemInserted(users.size - 1)
    }

    fun removeLoadingFooter() {
        if (users.isNotEmpty() && users.last().isLoading) {
            val position = users.size - 1
            users.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    private var onItemClickListener: ((User) -> Unit)? = null

    fun setOnItemClickListener(listener: (User) -> Unit) {
        onItemClickListener = listener
    }
}