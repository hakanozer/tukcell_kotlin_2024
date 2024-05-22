package com.sercancelik.odev9.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImageWithGlide(url: String) {
    Glide.with(this.context)
        .load(url)
        .into(this)
}
