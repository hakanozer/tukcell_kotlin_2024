package com.muratdayan.vize2.components

import android.app.Activity
import android.icu.text.CaseMap.Title
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import com.muratdayan.vize2.R

class CustomToast ( val activity: Activity, val title: String,  val duration: Int) {

    val toast = Toast(activity)
    val custom_alert_view = activity.layoutInflater.inflate(R.layout.custom_toast_view, null)
    lateinit var customToastTitle: TextView

    fun show() {
        customToastTitle = custom_alert_view.findViewById(R.id.txtcustomToastViewMessage)
        customToastTitle.setText(title)
        toast.duration = Toast.LENGTH_SHORT
        toast.setGravity(Gravity.CENTER_VERTICAL, 0 ,0)
        toast.view = custom_alert_view
        toast.show()
    }


}