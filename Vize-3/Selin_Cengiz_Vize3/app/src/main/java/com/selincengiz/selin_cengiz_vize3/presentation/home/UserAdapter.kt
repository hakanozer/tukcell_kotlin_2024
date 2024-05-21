package com.selincengiz.selin_cengiz_vize3.presentation.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.selincengiz.selin_cengiz_vize3.common.Extensions.loadUrl
import com.selincengiz.selin_cengiz_vize3.databinding.ItemUserBinding
import com.selincengiz.selin_cengiz_vize3.domain.entities.UserUI

class UserAdapter(val onClick: (user: UserUI) -> Unit) :
    ListAdapter<UserUI, UserAdapter.RecipeViewHolder>(NewsDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder =
        RecipeViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class RecipeViewHolder(
        private val binding: ItemUserBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(userUI: UserUI) = with(binding) {
            image.loadUrl(userUI.image)
            title.text = userUI.username

            root.setOnClickListener {
                onClick(userUI)
            }
        }
    }

    class NewsDiffCallBack : DiffUtil.ItemCallback<UserUI>() {
        override fun areItemsTheSame(oldItem: UserUI, newItem: UserUI): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserUI, newItem: UserUI): Boolean {
            return oldItem == newItem
        }
    }
}