package com.example.cityapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cityapp.data.entity.NewsInfo
import com.example.cityapp.data.repo.CityDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsFragmentViewModel @Inject constructor(private var cRepo: CityDaoRepository) : ViewModel() {

    var newsList = MutableLiveData<List<NewsInfo>?>()

    private fun loadNews() {
        newsList = cRepo.newsList
    }

    init {
        loadNews()
    }
}