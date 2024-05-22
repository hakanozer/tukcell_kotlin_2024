package com.example.eray_altilar_odev_9.presentation.main_screen

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eray_altilar_odev_9.R

class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val rImage: ImageView = itemView.findViewById(R.id.r_image)
    val rTitle: TextView = itemView.findViewById(R.id.r_title)
    val rPrice: TextView = itemView.findViewById(R.id.r_price)
}