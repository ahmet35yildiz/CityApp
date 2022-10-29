package com.example.cityapp.util

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun showSnackbar(v: View, msg: String) {
    Snackbar.make(v, msg, Snackbar.LENGTH_SHORT).show()
}