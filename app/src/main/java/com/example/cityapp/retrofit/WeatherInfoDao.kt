package com.example.cityapp.retrofit

import com.example.cityapp.data.entity.NewsInfoResponse
import com.example.cityapp.data.entity.PharmacyInfoResponse
import com.example.cityapp.data.entity.WeatherInfoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherInfoDao {
    // @Headers("content-type: application/json","authorization: apikey 2O9ftxOWBwYxSrpNQFgiUP:02PXfUm7l5QpJqEct7XkAp")
    @GET("weather/getWeather")
    fun getWeatherInfo(
        @Query("data.lang") language: String?,
        @Query("data.city") city: String?
    ): Call<WeatherInfoResponse>

    @GET("health/dutyPharmacy")
    fun getPharmacyInfo(
        @Query("il") city: String?
    ): Call<PharmacyInfoResponse>

    @GET("news/getNews")
    fun getNewsInfo(
        @Query("country") country: String?,
        @Query("tag") tag: String?
    ): Call<NewsInfoResponse>
}