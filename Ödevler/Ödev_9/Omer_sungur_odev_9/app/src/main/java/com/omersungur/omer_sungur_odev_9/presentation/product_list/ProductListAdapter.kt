package com.omersungur.omer_sungur_odev_9.presentation.product_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.omersungur.omer_sungur_odev_9.databinding.ProductRowBinding
import com.omersungur.omer_sungur_odev_9.domain.model.Product

class ProductListAdapter(
    private val productList: MutableList<Product>
) : RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {

    class ProductViewHolder(val binding: ProductRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val adapterLayout = ProductRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ProductViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]

        holder.binding.textView.text = product.title
        Glide.with(holder.itemView.context).load(product.thumbnail).into(holder.binding.imageView)
    }

    override fun getItemCount(): Int = productList.size

    fun addProducts(newProducts: List<Product>) {
        val oldItemCount = itemCount
        productList.addAll(newProducts)
        notifyItemRangeInserted(oldItemCount, newProducts.size)
    }
}