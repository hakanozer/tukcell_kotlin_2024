package com.selincengiz.selin_cengiz_odev8.common

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.selincengiz.selin_cengiz_odev8.R


import java.util.Calendar

object Extensions {
    fun ImageView.loadUrl(url: String?) {
        Glide.with(this.context).load(url).placeholder(R.drawable.default_recipe)
            .error(R.drawable.default_recipe).into(this)
    }
}