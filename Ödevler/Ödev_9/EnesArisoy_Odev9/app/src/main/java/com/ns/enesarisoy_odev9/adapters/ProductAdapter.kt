package com.ns.enesarisoy_odev9.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ns.enesarisoy_odev9.databinding.ItemLoadingBinding
import com.ns.enesarisoy_odev9.databinding.ItemProductsBinding
import com.ns.enesarisoy_odev9.model.Product

class ProductAdapter(private val products: MutableList<Product>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_ITEM = 0
    private val VIEW_TYPE_LOADING = 1

    inner class ProductViewHolder(private val binding: ItemProductsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.apply {
                tvProductName.text = product.title
                tvProductPrice.text = "${product.price} $"
                Glide.with(binding.root.context)
                    .load(product.images?.get(0))
                    .into(ivProductImage)
            }
        }
    }

    inner class LoadingViewHolder(private val binding: ItemLoadingBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_ITEM) {
            val binding =
                ItemProductsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ProductViewHolder(binding)
        } else {
            val binding =
                ItemLoadingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            LoadingViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ProductViewHolder) {
            holder.bind(products[position])
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (products[position].isLoading) VIEW_TYPE_LOADING else VIEW_TYPE_ITEM
    }

    fun addProducts(newProducts: List<Product>) {
        val startPosition = products.size
        products.addAll(newProducts)
        notifyItemRangeInserted(startPosition, newProducts.size)
    }

    fun addLoadingFooter() {
        products.add(Product(isLoading = true))
        notifyItemInserted(products.size - 1)
    }

    fun removeLoadingFooter() {
        if (products.isNotEmpty() && products.last().isLoading) {
            val position = products.size - 1
            products.removeAt(position)
            notifyItemRemoved(position)
        }
    }
}