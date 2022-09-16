package com.example.cityapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cityapp.R
import com.example.cityapp.ui.adapter.WeatherAdapter
import com.example.cityapp.databinding.FragmentWeatherBinding
import com.example.cityapp.data.entity.WeatherInfo
import com.example.cityapp.ui.viewmodel.WeatherFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherFragment : Fragment() {
    private lateinit var binding: FragmentWeatherBinding
    private lateinit var viewModel: WeatherFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_weather, container, false)

        binding.weatherFragment = this

        viewModel.weatherList.observe(viewLifecycleOwner){
            val adapter = WeatherAdapter(it)
            binding.weatherAdapter = adapter
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:WeatherFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }
}