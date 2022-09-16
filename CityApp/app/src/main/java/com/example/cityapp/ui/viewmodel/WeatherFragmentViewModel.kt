package com.example.cityapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cityapp.data.entity.WeatherInfo
import com.example.cityapp.data.repo.CityDaoRepository

class WeatherFragmentViewModel : ViewModel(){
    val cRepo = CityDaoRepository()
    var weatherList = MutableLiveData<List<WeatherInfo>>()

    init {
        loadWeather()
        weatherList = cRepo.showWeather()
    }
    fun loadWeather() {
        cRepo.getWeather()
    }
}