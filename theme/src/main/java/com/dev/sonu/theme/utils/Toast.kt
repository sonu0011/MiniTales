package com.dev.sonu.theme.utils

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

fun Context.toast(
    message: String,
    onToastDisplayMessage: (Boolean) -> Unit
) {
    showToast(message, onToastDisplayMessage)
}

fun Context.toast(
    @StringRes message: Int,
    onToastDisplayMessage: (Boolean) -> Unit
) {
    showToast(getString(message), onToastDisplayMessage)
}

private fun Context.showToast(
    message: String,
    onToastDisplayMessage: (Boolean) -> Unit
) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).also {
        it.addCallback(object : Toast.Callback() {
            override fun onToastShown() {
                super.onToastShown()
                onToastDisplayMessage(true)
            }

            override fun onToastHidden() {
                super.onToastHidden()
                onToastDisplayMessage(false)
            }
        })
    }.show()

}