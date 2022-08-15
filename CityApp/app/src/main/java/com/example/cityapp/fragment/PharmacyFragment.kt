package com.example.cityapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cityapp.R
import com.example.cityapp.databinding.FragmentPharmacyBinding

class PharmacyFragment : Fragment() {
    private lateinit var binding: FragmentPharmacyBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentPharmacyBinding.inflate(inflater, container, false)
        return binding.root
    }
}