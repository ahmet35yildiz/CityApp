package com.example.cityapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.Navigation
import com.example.cityapp.R
import com.example.cityapp.databinding.FragmentHomepageBinding
import com.google.android.material.snackbar.Snackbar

class HomepageFragment : Fragment() {
    private lateinit var binding: FragmentHomepageBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentHomepageBinding.inflate(inflater, container, false)

        val adapterSpinner = ArrayAdapter.createFromResource(requireContext(),
            R.array.cityList,android.R.layout.simple_spinner_item)
        adapterSpinner.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)

        with(binding){
            toolbarHomepage.title = "CityApp"
            spinner.adapter = adapterSpinner
            cardViewWeather.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.weatherTransition)
            }
            cardViewFuel.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.fuelTransition)
            }
            cardViewPharmacy.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.pharmacyTransition)
            }
            buttonCitySelect.setOnClickListener {
                Snackbar.make(it,"${binding.spinner.selectedItem.toString().toLowerCase()} seçildi !",
                    Snackbar.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }
}