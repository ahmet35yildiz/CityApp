package com.example.cityapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cityapp.data.entity.PharmacyInfo
import com.example.cityapp.data.repo.CityDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PharmacyFragmentViewModel @Inject constructor(private var cRepo: CityDaoRepository) : ViewModel() {

    var pharmacyList = MutableLiveData<List<PharmacyInfo>?>()

    private fun loadPharmacy() {
        pharmacyList = cRepo.pharmacyList
    }

    init {
        loadPharmacy()
    }
}