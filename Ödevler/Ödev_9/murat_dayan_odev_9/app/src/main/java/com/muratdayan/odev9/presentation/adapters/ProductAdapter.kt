package com.muratdayan.odev9.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.muratdayan.odev9.R
import com.muratdayan.odev9.databinding.ProductRowBinding
import com.muratdayan.odev9.domain.models.Product

class ProductAdapter(
    private var productList: MutableList<Product>
) : RecyclerView.Adapter<ProductAdapter.ProductRowHolder>() {


    inner class ProductRowHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ProductRowBinding.bind(view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductRowHolder {
        val design = LayoutInflater.from(parent.context).inflate(R.layout.product_row, parent, false)
        return ProductRowHolder(design)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductRowHolder, position: Int) {

        val product = productList[position]

        holder.binding.productRowTxtTitle.setText(product.title)
        holder.binding.productRowTxtPrice.setText(product.price.toString())

        Glide.with(holder.binding.root).load(product.thumbnail).into(holder.binding.productRowImgView)

    }

    // yeni gelen her 10 veriyi mevcut recycler view listesine ekler
    fun addProducts(newProducts: List<Product>) {
        val oldItemCount = itemCount
        productList.addAll(newProducts)
        notifyItemRangeInserted(oldItemCount, newProducts.size)
    }

}