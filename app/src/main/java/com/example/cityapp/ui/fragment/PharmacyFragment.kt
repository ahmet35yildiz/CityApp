package com.example.cityapp.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.cityapp.R
import com.example.cityapp.data.entity.PharmacyInfo
import com.example.cityapp.databinding.FragmentPharmacyBinding
import com.example.cityapp.ui.adapter.PharmacyAdapter
import com.example.cityapp.ui.viewmodel.PharmacyFragmentViewModel
import com.example.cityapp.util.showSnackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PharmacyFragment : Fragment() {

    private lateinit var binding: FragmentPharmacyBinding

    private val viewModel: PharmacyFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pharmacy, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.pharmacyList.observe(viewLifecycleOwner) {
            with(binding) {
                pharmacyFragment = this@PharmacyFragment

                if (it != null) {
                    val adapter = PharmacyAdapter(it) {
                        showDirection(it)
                    }
                    pharmacyAdapter = adapter
                    animationLoading.visibility = View.GONE
                    animationError.visibility = View.GONE
                } else {
                    animationLoading.visibility = View.GONE
                    animationError.visibility = View.VISIBLE
                    showSnackbar(view,"Bir hata oluştu, lütfen daha sonra tekrar deneyiniz.")
                }
            }
        }
    }

    private fun showDirection(pharmacy: PharmacyInfo) {
        val uri = android.net.Uri.parse("geo: ${pharmacy.pharmacyLocation}?q=${pharmacy.pharmacyName}")
        val mapIntent = Intent(Intent.ACTION_VIEW, uri)
        mapIntent.setPackage("com.google.android.apps.maps")
        ContextCompat.startActivity(requireContext(), mapIntent, null)
    }
}