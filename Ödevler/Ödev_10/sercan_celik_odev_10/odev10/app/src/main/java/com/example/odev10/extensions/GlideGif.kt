package com.example.odev10.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import android.util.Log

fun ImageView.loadGif(resourceId: Int) {
    Log.d("GifLoader", "Loading GIF with resource ID: $resourceId")
    Glide.with(this.context)
        .asGif()
        .load(resourceId)
        .into(this)
}

fun ImageView.loadImage(resourceId: Int) {
    Log.d("ImageLoader", "Loading image with resource ID: $resourceId")
    Glide.with(this.context)
        .load(resourceId)
        .into(this)
}
