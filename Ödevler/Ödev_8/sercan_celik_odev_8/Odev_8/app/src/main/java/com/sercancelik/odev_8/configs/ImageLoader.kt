package com.sercancelik.odev_8.configs

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

object ImageLoader {
    fun loadImage(context: Context, imageUrl: String, imageView: ImageView) {
        Glide.with(context)
            .load(imageUrl)
            .into(imageView)
    }
}
