package com.example.eray_altilar_odev_9.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eray_altilar_odev_9.model.Product
import com.example.eray_altilar_odev_9.presentation.main_screen.ProductViewHolder
import com.example.eray_altilar_odev_9.R
import com.bumptech.glide.Glide

class ProductAdapter(private val products: MutableList<Product>) : RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.product_row, parent, false)
        return ProductViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.rTitle.text = product.title
        holder.rPrice.text = "${product.price}₺"
        Glide.with(holder.itemView.context).load(product.thumbnail).into(holder.rImage)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    fun addProducts(newProducts: List<Product>) {
        val startPosition = products.size
        products.addAll(newProducts)
        notifyItemRangeInserted(startPosition, newProducts.size)
    }
}


