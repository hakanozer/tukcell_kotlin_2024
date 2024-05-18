package com.omersungur.recipeapp_hw8.core

import android.content.Context
import android.widget.Toast

fun Context.customToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}