package com.example.cityapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.cityapp.data.repo.CityDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomepageFragmentViewModel @Inject constructor (var cRepo:CityDaoRepository) : ViewModel() {

    fun select(selectedCity:String){
        cRepo.chooseCity(selectedCity)
    }
}