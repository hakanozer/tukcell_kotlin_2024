package com.bengisusahin.odev_10.utils

import android.app.DatePickerDialog
import android.content.Context
import android.widget.EditText
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

object DateUtils {
    fun showDatePickerDialog(context: Context, editText: EditText) {
        val calendar = Calendar.getInstance()
        editText.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                context,
                { _, year, month, dayOfMonth ->
                    val selectedDate = Calendar.getInstance().apply {
                        set(Calendar.YEAR, year)
                        set(Calendar.MONTH, month)
                        set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    }
                    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                    val formattedDate = dateFormat.format(selectedDate.time)
                    editText.setText(formattedDate)
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
            datePickerDialog.show()
        }
    }
}