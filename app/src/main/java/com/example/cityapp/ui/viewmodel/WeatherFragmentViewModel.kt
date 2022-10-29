package com.example.cityapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cityapp.data.entity.WeatherInfo
import com.example.cityapp.data.repo.CityDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherFragmentViewModel @Inject constructor(private var cRepo: CityDaoRepository) : ViewModel() {

    var weatherList = MutableLiveData<List<WeatherInfo>?>()

    private fun loadWeather() {
        weatherList = cRepo.weatherList
    }

    init {
        loadWeather()
    }
}