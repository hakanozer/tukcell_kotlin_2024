package com.selincengiz.selin_cengiz_vize3.common


import android.widget.ImageView
import com.bumptech.glide.Glide
import com.selincengiz.selin_cengiz_vize3.R


object Extensions {
    fun ImageView.loadUrl(url: String?) {
        Glide.with(this.context).load(url).placeholder(R.drawable.default_recipe)
            .error(R.drawable.default_recipe).into(this)
    }

    fun ImageView.loadUrlCenterCrop(url: String?) {
        Glide.with(this.context).load(url).centerCrop().placeholder(R.drawable.default_recipe)
            .error(R.drawable.default_recipe).into(this)
    }
}