package com.example.cityapp.util

import android.view.View
import androidx.navigation.Navigation

fun Navigation.useTransition(v:View,id:Int){
    findNavController(v).navigate(id)
}