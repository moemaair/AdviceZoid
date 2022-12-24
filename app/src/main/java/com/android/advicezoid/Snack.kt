package com.android.advicezoid
import android.view.View
import com.google.android.material.snackbar.Snackbar


fun View.snack(message: String, duration: Int = Snackbar.LENGTH_SHORT ) {
    Snackbar.make(this, message, duration).show()
}
