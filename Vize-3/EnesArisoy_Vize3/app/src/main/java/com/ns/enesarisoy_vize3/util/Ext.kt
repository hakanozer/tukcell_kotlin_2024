package com.ns.enesarisoy_vize3.util

import android.view.View

fun View.visible() {
    if (visibility == View.GONE) {
        animate().alpha(1f).withStartAction {
            visibility = View.VISIBLE
        }
    }
}

fun View.gone() {
    if (visibility == View.VISIBLE) {
        animate().alpha(0f).withEndAction {
            visibility = View.GONE
        }
    }
}