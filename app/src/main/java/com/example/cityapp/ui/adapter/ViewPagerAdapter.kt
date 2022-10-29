package com.example.cityapp.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cityapp.ui.fragment.NewsFragment
import com.example.cityapp.ui.fragment.PharmacyFragment
import com.example.cityapp.ui.fragment.WeatherFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return WeatherFragment()
            1 -> return NewsFragment()
        }
        return PharmacyFragment()
    }

    companion object {
        private const val NUM_TABS = 3
    }
}