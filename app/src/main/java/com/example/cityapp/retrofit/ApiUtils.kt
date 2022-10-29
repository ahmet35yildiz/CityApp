package com.example.cityapp.retrofit

class ApiUtils {
    companion object {
        private const val BASE_URL = "https://api.collectapi.com/"
        fun getWeatherInfoDao(): WeatherInfoDao {
            return RetrofitClient.getClient(BASE_URL).create(WeatherInfoDao::class.java)
        }
    }
}