package com.example.cityapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.cityapp.data.repo.CityDaoRepository

class HomepageFragmentViewModel : ViewModel() {
    val cRepo = CityDaoRepository()

    fun select(selectedCity:String){
        cRepo.chooseCity(selectedCity)
    }
}