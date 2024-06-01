package com.muratdayan.odev10.common.utils

import android.content.Context
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

//snackbar extension fonksiyonu
fun View.showSnackbar(
    message: String,
    actionText: String = "Yes",
    duration: Int = Snackbar.LENGTH_LONG,
    action: () -> Unit
) {
    val snackbar = Snackbar.make(this, message, duration)
    snackbar.setAction(actionText) {
        action()
    }

    snackbar.show()
}

// Alert dialog extension fonksiyonu
fun Fragment.showAlertDialog(
    title: String = "Sign Up",
    message: String = "Such a record could not be found. Would you like to register?",
    onPositiveClick: (dialog: AlertDialog) -> Unit,
    onNegativeClick: (dialog: AlertDialog) -> Unit
) {
    val builder = AlertDialog.Builder(requireContext())

    builder.setTitle(title)
    builder.setMessage(message)

    builder.setPositiveButton("Yes") { dialog, which ->
        onPositiveClick(dialog as AlertDialog)
    }

    builder.setNegativeButton("No") { dialog, which ->
        onNegativeClick(dialog as AlertDialog)
    }

    val dialog = builder.create()
    dialog.show()
}