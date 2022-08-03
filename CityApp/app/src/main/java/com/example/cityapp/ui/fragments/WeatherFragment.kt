package com.example.cityapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cityapp.R
import com.example.cityapp.data.entity.Weather
import com.example.cityapp.databinding.FragmentWeatherBinding
import com.example.cityapp.ui.adapters.WeatherAdapter

class WeatherFragment : Fragment() {
    private lateinit var binding: FragmentWeatherBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentWeatherBinding.inflate(inflater, container, false)

        binding.toolbarWeather.title = "Hava Durumu"
        binding.rvWeather.layoutManager = LinearLayoutManager(requireContext())

        val weatherList = ArrayList<Weather>()
        val w1 = Weather("01.02.2022","Salı","Yağmurlu","Rainy","20","15","25","15","40")
        val w2 = Weather("05.02.2022","Cumartesi","Güneşli","Clear","20","15","25","15","40")
        weatherList.add(w1)
        weatherList.add(w2)

        val adapter = WeatherAdapter(requireContext(),weatherList)
        binding.rvWeather.adapter = adapter

        return (binding.root)
    }
}