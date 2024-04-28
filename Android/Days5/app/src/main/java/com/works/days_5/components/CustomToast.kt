package com.works.days_5.components

import android.app.Activity
import android.content.Context
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import com.works.days_5.R

class CustomToast( val activity: Activity, val title: String, val detail: String, val duration: Int) {

    val toast = Toast(activity)
    val custom_alert_view = activity.layoutInflater.inflate(R.layout.custom_alert, null)
    lateinit var alert_title: TextView
    lateinit var alert_detail: TextView

    fun show() {
        alert_title = custom_alert_view.findViewById(R.id.alert_title)
        alert_detail = custom_alert_view.findViewById(R.id.alert_detail)
        alert_title.setText(title)
        alert_detail.setText(detail)
        toast.duration = Toast.LENGTH_SHORT
        toast.setGravity(Gravity.CENTER_VERTICAL, 0 ,0)
        toast.view = custom_alert_view
        toast.show()
    }


}