package com.example.cityapp.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.cityapp.data.entity.WeatherInfo

class CityDaoRepository {
    var weatherList:MutableLiveData<List<WeatherInfo>>

    init {
        weatherList = MutableLiveData()
    }

    fun showWeather(): MutableLiveData<List<WeatherInfo>>{
        return weatherList
    }

    fun chooseCity(selectedCity:String){
        Log.e("city","$selectedCity seçildi.")
    }
    fun getWeather(){
        val weatherListInfo = ArrayList<WeatherInfo>()
        val w1 = WeatherInfo("Pazartesi","12.09.2022","","40","27.3","40")
        val w2 = WeatherInfo("Salı","13.09.2022","","32.3","28.1","38")
        val w3 = WeatherInfo("Çarşamba","14.09.2022","","33.3","29.9","39")
        weatherListInfo.add(w1)
        weatherListInfo.add(w2)
        weatherListInfo.add(w3)
        weatherList.value = weatherListInfo
    }
}