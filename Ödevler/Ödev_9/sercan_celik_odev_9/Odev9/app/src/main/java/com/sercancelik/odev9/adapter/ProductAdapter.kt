package com.sercancelik.odev9.adapter

import android.content.Context
import android.graphics.Paint
import android.icu.text.DecimalFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sercancelik.odev9.R
import com.sercancelik.odev9.extension.loadImageWithGlide
import com.sercancelik.odev9.models.Product

class ProductAdapter(private val context: Context, private var productList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    fun updateData(newData: List<Product>) {
        productList = newData
        notifyDataSetChanged()
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.findViewById(R.id.textViewTitle)
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)
        private val ratingBar: RatingBar = itemView.findViewById(R.id.smallRating)
        private val beforePrice: TextView = itemView.findViewById(R.id.textPrice)
        private val percentage: TextView = itemView.findViewById(R.id.textViewPercentage)
        private val afterPrice: TextView = itemView.findViewById(R.id.textViewNewPrice)


        fun bind(product: Product) {
            val decimalFormat = DecimalFormat("#,##0.00")
            val paint = Paint()
            paint.flags = Paint.STRIKE_THRU_TEXT_FLAG
            name.text = product.title
            imageView.loadImageWithGlide(product.thumbnail)
            ratingBar.rating = product.rating
            beforePrice.paintFlags = beforePrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            val formattedBeforePrice = decimalFormat.format(product.price)
            beforePrice.text = formattedBeforePrice.toString() + "₺"
            percentage.text = product.discountPercentage.toString() + " %"

            val price = product.price * (1 - product.discountPercentage / 100)

            val formattedPrice = decimalFormat.format(price)
            afterPrice.text = "$formattedPrice ₺"
        }
    }
}
