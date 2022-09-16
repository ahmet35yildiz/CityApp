package com.example.cityapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.cityapp.data.repo.CityDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PharmacyFragmentViewModel @Inject constructor (var cRepo: CityDaoRepository) : ViewModel() {
}