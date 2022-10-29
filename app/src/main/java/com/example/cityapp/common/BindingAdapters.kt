package com.example.cityapp.common

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("degree", "maxMin")
fun setDegree(
    degreeText: TextView,
    degree: String,
    maxMin: String
) {
    if (maxMin == "max") {
        val doubleValue = degree.toDouble()
        degreeText.text = String.format("%.0f°C", doubleValue)
    } else {
        val doubleValue = degree.toDouble()
        degreeText.text = String.format("Min: %.0f°C", doubleValue)
    }
}

@BindingAdapter("imageUrl")
fun setImage(
    imageView: ImageView,
    imageUrl: String?
) {
    if (imageUrl.isNullOrEmpty().not()) {
        Picasso.get().load(imageUrl).into(imageView)
    }
}