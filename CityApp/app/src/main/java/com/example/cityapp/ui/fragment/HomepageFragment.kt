package com.example.cityapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.cityapp.R
import com.example.cityapp.databinding.FragmentHomepageBinding
import com.example.cityapp.ui.viewmodel.HomepageFragmentViewModel
import com.example.cityapp.util.useTransition
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomepageFragment : Fragment() {
    private lateinit var binding: FragmentHomepageBinding
    private lateinit var viewModel: HomepageFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_homepage, container, false)

        val adapterSpinner = ArrayAdapter.createFromResource(requireContext(),
            R.array.cityList,android.R.layout.simple_spinner_item)
        adapterSpinner.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)

        with(binding){
            homepageFragment = this@HomepageFragment
            homepageToolbarTitle = "CityApp"
            spinner.adapter = adapterSpinner

            buttonCitySelect.setOnClickListener {
                val selectedCity = spinner.selectedItem.toString().toLowerCase()
                selectCity(selectedCity)
            }
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {  //Yukarıda tanımlanan global viewModele fragmentta olduğumuz için bu şekilde değer aktarıyoruz.
        super.onCreate(savedInstanceState)
        val tempViewModel: HomepageFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }
    fun selectCity(selectedCity:String){
        viewModel.select(selectedCity)
    }
    fun weatherTransition(v:View){
        Navigation.useTransition(v,R.id.weatherTransition)
    }
    fun fuelTransition(v:View){
        Navigation.useTransition(v,R.id.fuelTransition)
    }
    fun pharmacyTransition(v:View){
        Navigation.useTransition(v,R.id.pharmacyTransition)
    }
}