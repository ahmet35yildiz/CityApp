package com.example.cityapp.data.entity

import com.google.gson.annotations.SerializedName

data class WeatherInfo(
    @SerializedName("day") var weatherDay: String?,
    @SerializedName("date") var weatherDate: String?,
    @SerializedName("icon") var weatherIcon: String?,
    @SerializedName("max") var weatherMaxDegree: String?,
    @SerializedName("min") var weatherMinDegree: String?,
    @SerializedName("humidity") var weatherHumidity: String?
)