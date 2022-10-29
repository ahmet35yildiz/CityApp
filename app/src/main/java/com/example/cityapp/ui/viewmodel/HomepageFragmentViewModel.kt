package com.example.cityapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.cityapp.data.repo.CityDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomepageFragmentViewModel @Inject constructor(private var cRepo: CityDaoRepository) : ViewModel() {

    fun selectCityWeather(selectedCity: String) {
        cRepo.getWeather(selectedCity)
    }

    fun selectCityPharmacy(selectedCity: String) {
        cRepo.getPharmacy(selectedCity)
    }

    fun selectCityNews() {
        cRepo.getNews()
    }
}