package com.muratdayan.odev10.common.components

import android.app.Activity
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import com.muratdayan.odev10.R

class CustomToast (val activity: Activity, val title: String, val duration: Int) {

    val toast = Toast(activity)
    val custom_alert_view = activity.layoutInflater.inflate(R.layout.custom_toast, null)
    private lateinit var customToastTitle: TextView

    // custom toastı gösterme fonksiyonu
    fun show() {
        customToastTitle = custom_alert_view.findViewById(R.id.customToastTxtTitle)
        customToastTitle.setText(title)
        toast.duration = Toast.LENGTH_SHORT
        toast.setGravity(Gravity.BOTTOM, 0 ,0)
        toast.view = custom_alert_view
        toast.show()
    }


}