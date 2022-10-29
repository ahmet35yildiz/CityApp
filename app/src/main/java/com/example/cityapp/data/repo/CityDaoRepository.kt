package com.example.cityapp.data.repo

import androidx.lifecycle.MutableLiveData
import com.example.cityapp.data.entity.*
import com.example.cityapp.retrofit.WeatherInfoDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CityDaoRepository(private var cDao: WeatherInfoDao) {

    var weatherList = MutableLiveData<List<WeatherInfo>?>()
    var pharmacyList = MutableLiveData<List<PharmacyInfo>?>()
    var newsList = MutableLiveData<List<NewsInfo>?>()

    fun getWeather(confirmedCity: String) {
        cDao.getWeatherInfo("tr", confirmedCity).enqueue(object : Callback<WeatherInfoResponse> {
            override fun onResponse(
                call: Call<WeatherInfoResponse>,
                response: Response<WeatherInfoResponse>
            ) {
                val weatherResponseList = response.body()?.resultWeather
                if (weatherResponseList == null) {
                    weatherList.value = null
                } else {
                    weatherList.value = weatherResponseList
                }
            }

            override fun onFailure(call: Call<WeatherInfoResponse>, t: Throwable) {}
        })
    }

    fun getPharmacy(confirmedCity: String) {
        if (pharmacyList.value == null) {
            cDao.getPharmacyInfo(confirmedCity).enqueue(object : Callback<PharmacyInfoResponse> {
                override fun onResponse(
                    call: Call<PharmacyInfoResponse>,
                    response: Response<PharmacyInfoResponse>
                ) {
                    val pharmacyResponseList = response.body()?.resultPharmacy
                    if (pharmacyResponseList == null) {
                        pharmacyList.value = null
                    } else {
                        pharmacyList.value = pharmacyResponseList
                    }
                }

                override fun onFailure(call: Call<PharmacyInfoResponse>, t: Throwable) {}
            })
        }
    }

    fun getNews() {
        cDao.getNewsInfo("tr", "general").enqueue(object : Callback<NewsInfoResponse> {
            override fun onResponse(
                call: Call<NewsInfoResponse>,
                response: Response<NewsInfoResponse>
            ) {
                val newsResponseList = response.body()?.resultNews
                if (newsResponseList == null) {
                    newsList.value = null
                } else {
                    newsList.value = newsResponseList
                }
            }

            override fun onFailure(call: Call<NewsInfoResponse>, t: Throwable) {}
        })
    }
}