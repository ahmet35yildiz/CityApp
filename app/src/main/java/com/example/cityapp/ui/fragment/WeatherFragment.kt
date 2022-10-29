package com.example.cityapp.ui.fragment

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.cityapp.R
import com.example.cityapp.databinding.FragmentWeatherBinding
import com.example.cityapp.ui.adapter.WeatherAdapter
import com.example.cityapp.ui.viewmodel.WeatherFragmentViewModel
import com.example.cityapp.util.showSnackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherFragment : Fragment() {

    private lateinit var binding: FragmentWeatherBinding

    private val viewModel: WeatherFragmentViewModel by viewModels()

    private lateinit var sharedPref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_weather, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPref = requireActivity().getSharedPreferences(HomepageFragment.PREFS_FILENAME, 0)

        viewModel.weatherList.observe(viewLifecycleOwner) {
            with(binding) {
                weatherFragment = this@WeatherFragment

                if (it != null) {
                    val adapter = WeatherAdapter(it)
                    weatherAdapter = adapter
                    animationLoading.visibility = View.GONE
                    animationError.visibility = View.GONE
                }
                else if (sharedPref.getString(HomepageFragment.PREF_KEY_CITY, "") == "") {
                    animationLoading.visibility = View.GONE
                    animationError.visibility = View.GONE
                }
                else {
                    animationLoading.visibility = View.GONE
                    animationError.visibility = View.VISIBLE
                    showSnackbar(view,"Bir hata oluştu, lütfen daha sonra tekrar deneyiniz.")
                }
            }
        }
    }
}