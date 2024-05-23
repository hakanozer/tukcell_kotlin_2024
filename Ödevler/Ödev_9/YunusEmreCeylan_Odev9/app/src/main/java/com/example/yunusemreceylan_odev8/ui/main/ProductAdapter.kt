package com.example.yunusemreceylan_odev8.ui.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.yunusemreceylan_odev8.R
import com.example.yunusemreceylan_odev8.data.model.Product
import com.example.yunusemreceylan_odev8.ui.detail.DetailActivity

class ProductPagingDataAdapter : PagingDataAdapter<Product, ProductPagingDataAdapter.ProductViewHolder>(PRODUCT_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = getItem(position)
        if (product != null) {
            holder.bind(product)
        }
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.r_image)
        private val nameTextView: TextView = itemView.findViewById(R.id.r_name)
        private val caloriesTextView: TextView = itemView.findViewById(R.id.r_caloriesPer)

        init {
            itemView.setOnClickListener {
                val product = getItem(bindingAdapterPosition)
                if (product != null) {
                    val intent = Intent(itemView.context, DetailActivity::class.java).apply {
                        putExtra("product", product)
                    }
                    itemView.context.startActivity(intent)
                }
            }
        }

        fun bind(product: Product) {
            nameTextView.text = product.title
            caloriesTextView.text = product.brand
            Glide.with(itemView.context).load(product.images[0]).into(imageView)
        }
    }

    companion object {
        private val PRODUCT_COMPARATOR = object : DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean =
                oldItem == newItem
        }
    }
}

