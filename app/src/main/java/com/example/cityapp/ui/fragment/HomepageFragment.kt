package com.example.cityapp.ui.fragment

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.cityapp.R
import com.example.cityapp.databinding.FragmentHomepageBinding
import com.example.cityapp.ui.adapter.ViewPagerAdapter
import com.example.cityapp.ui.viewmodel.HomepageFragmentViewModel
import com.example.cityapp.util.showSnackbar
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomepageFragment : Fragment() {
    private lateinit var binding: FragmentHomepageBinding
    private val viewModel: HomepageFragmentViewModel by viewModels()

    private lateinit var sharedPref: SharedPreferences
    private val fragmentsArray = arrayOf("HAVA DURUMU", "HABERLER", "NÖBETÇİ ECZANELER")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_homepage, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {

            homepageFragment = this@HomepageFragment

            val adapter = ViewPagerAdapter(childFragmentManager, lifecycle)
            viewPagerHomepage.adapter = adapter

            TabLayoutMediator(
                tabLayoutHomepage,
                viewPagerHomepage
            ) { tab, position -> //tabLayout ve viewPager arasında bağlantı kuruyoruz
                tab.text = fragmentsArray[position]
            }.attach()

            sharedPref = requireActivity().getSharedPreferences(PREFS_FILENAME, 0)

            sharedPref.getString(PREF_KEY_CITY, "")?.let {
                if (it.isNotEmpty()) viewModel.selectCityWeather(it) //sharedPref'ten şehir bilgisi alınıp viewModel'e gönderilerek hava durumu bilgisi çekiliyor.
                else fabClick()
            }

            viewModel.selectCityWeather(
                sharedPref.getString(PREF_KEY_CITY, "").toString()
            ) //app açılınca direk hava durumunu getirmek için

            tabLayoutHomepage.addOnTabSelectedListener(object :
                TabLayout.OnTabSelectedListener { //tab değiştiğinde fab'ın görünüp görünmemesini ayarlamak ve gerekli api sorguların yapılması için
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    when (tab?.position) {
                        0 -> fab.visibility = View.VISIBLE
                        1 -> {
                            viewModel.selectCityNews()
                            fab.visibility = View.GONE
                        }
                        2 -> {
                            sharedPref.getString(PREF_KEY_CITY, "")?.let {
                                viewModel.selectCityPharmacy(it)
                            }
                            fab.visibility = View.VISIBLE
                        }
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {}

                override fun onTabReselected(tab: TabLayout.Tab?) {}
            })
        }
    }

    fun fabClick() {  //fab'a tıklandığında şehir seçme dialogu açılır
        var selectedCityIndex = 0
        val cityList = resources.getStringArray(R.array.cityList)
        var selectedCity = cityList[selectedCityIndex]

        MaterialAlertDialogBuilder(requireContext()).setTitle("Lütfen şehir seçiniz:")
            .setSingleChoiceItems(cityList, selectedCityIndex) { _, which ->
                selectedCityIndex = which
                selectedCity = cityList[which]
            }
            .setPositiveButton("TAMAM") { _, _ ->

                with(sharedPref.edit()) { //sharedPref'e seçilen şehir bilgisi kaydedilir
                    Log.e("pref", "$selectedCity çalıştı")
                    putString(PREF_KEY_CITY, selectedCity.toString().lowercase())
                    apply()
                }
                viewModel.selectCityWeather(selectedCity) //seçilen şehir için hava durumu getirilir

                showSnackbar(requireView(), "$selectedCity seçildi.")
            }.setNeutralButton("İPTAL") { _, _ -> }.show()
    }

    companion object { //sharedPref için
        const val PREFS_FILENAME = "com.example.cityapp.prefs"
        const val PREF_KEY_CITY = "cityWeather"
    }
}