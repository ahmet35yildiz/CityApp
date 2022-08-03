package com.example.cityapp.data.entity

import java.io.Serializable

data class Weather(var date:String,
                   var day:String,
                   var description:String,
                   var status:String,
                   var degree:String,
                   var min:String,
                   var max:String,
                   var night:String,
                   var humidity:String) : Serializable{
}