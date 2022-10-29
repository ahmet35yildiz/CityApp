package com.example.cityapp.data.entity

import com.google.gson.annotations.SerializedName

data class WeatherInfoResponse(@SerializedName("result") var resultWeather: List<WeatherInfo>)