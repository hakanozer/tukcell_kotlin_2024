package com.example.yusuf_mucahit_solmaz_odev_9.ui.adapter

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.yusuf_mucahit_solmaz_odev_9.R
import com.example.yusuf_mucahit_solmaz_odev_9.data.remote.model.Product
import com.example.yusuf_mucahit_solmaz_odev_9.databinding.ItemLoadingBinding
import com.example.yusuf_mucahit_solmaz_odev_9.databinding.ProductRowBinding

private const val VIEW_TYPE_ITEM = 0
private const val VIEW_TYPE_LOADING = 1

class ProductAdapter(private val products: MutableList<Product>, private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ProductViewHolder(private val binding: ProductRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.apply {
                titleTextView.text = product.title
                priceTextView.text = "$${product.price}"
                Glide.with(thumbnailImageView.context).load(product.thumbnail).into(thumbnailImageView)

                thumbnailImageView.setOnClickListener {
                    showImageDialog(product)
                }
            }
        }
    }

    inner class LoadingViewHolder(binding: ItemLoadingBinding) : RecyclerView.ViewHolder(binding.root)

    @SuppressLint("SetTextI18n")
    private fun showImageDialog(product: Product) {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.dialog_prouct_details)
        val imageView: ImageView = dialog.findViewById(R.id.imageView2)
        val textPrice: TextView = dialog.findViewById(R.id.textPrice)
        val textStock: TextView = dialog.findViewById(R.id.itemStock)
        val textTitle: TextView = dialog.findViewById(R.id.productTitle)
        val textDescription: TextView = dialog.findViewById(R.id.productDescription)
        val textRating: TextView = dialog.findViewById(R.id.productRating)

        textRating.text = "${product.rating}"
        textDescription.text = product.description
        textTitle.text = product.title
        textPrice.text = "($${product.price})"
        textStock.text = "${product.stock}"
        Glide.with(context)
            .load(product.thumbnail)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(imageView)

        dialog.show()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_ITEM) {
            val binding = ProductRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ProductViewHolder(binding)
        } else {
            val binding = ItemLoadingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            LoadingViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ProductViewHolder) {
            holder.bind(products[position])
        }
    }

    override fun getItemCount(): Int = products.size

    override fun getItemViewType(position: Int): Int {
        return if (products[position].id == -1) VIEW_TYPE_LOADING else VIEW_TYPE_ITEM
    }

    fun addProducts(newProducts: List<Product>) {
        val startPosition = products.size
        products.addAll(newProducts)
        notifyItemRangeInserted(startPosition, newProducts.size)
    }

    fun addLoadingFooter() {
        products.add(Product(id = -1, title = "", description = "", price = 0.0, discountPercentage = 0.0, rating = 0.0, stock = 0, brand = "", category = "", thumbnail = "", images = emptyList()))
        notifyItemInserted(products.size - 1)
    }

    fun removeLoadingFooter() {
        val position = products.size - 1
        if (position >= 0 && products[position].id == -1) {
            products.removeAt(position)
            notifyItemRemoved(position)
        }
    }
}