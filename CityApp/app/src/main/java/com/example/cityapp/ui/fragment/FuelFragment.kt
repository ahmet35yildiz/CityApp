package com.example.cityapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cityapp.databinding.FragmentFuelBinding

class FuelFragment : Fragment() {
    private lateinit var binding: FragmentFuelBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentFuelBinding.inflate(inflater, container, false)
        return binding.root
    }
}