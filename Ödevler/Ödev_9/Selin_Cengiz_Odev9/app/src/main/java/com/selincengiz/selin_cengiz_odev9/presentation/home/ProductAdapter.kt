package com.selincengiz.selin_cengiz_odev9.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.selincengiz.selin_cengiz_odev9.common.Extensions.loadUrl
import com.selincengiz.selin_cengiz_odev9.databinding.ItemProductBinding
import com.selincengiz.selin_cengiz_odev9.domain.entities.ProductUI

class ProductAdapter(
) : PagingDataAdapter<ProductUI, ProductAdapter.ProductViewHolder>(ProductDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder =
        ProductViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }

    class ProductViewHolder(
        private val binding: ItemProductBinding,
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: ProductUI) = with(binding) {

            ivProduct.loadUrl(product.thumbnail)
            tvPrice.text = product.price.toString()
            tvRating.text = product.rating.toString()
            tvTitleProduct.text = product.title.toString()


        }
    }

    class ProductDiffCallBack() : DiffUtil.ItemCallback<ProductUI>() {
        override fun areItemsTheSame(oldItem: ProductUI, newItem: ProductUI): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProductUI, newItem: ProductUI): Boolean {
            return oldItem == newItem
        }

    }


}

