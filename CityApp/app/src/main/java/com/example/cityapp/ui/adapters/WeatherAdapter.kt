package com.example.cityapp.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cityapp.R
import com.example.cityapp.data.entity.Weather
import com.example.cityapp.databinding.CardDesignWeatherBinding
import com.example.cityapp.databinding.FragmentWeatherBinding

class WeatherAdapter(var mContext:Context, var weatherList:List<Weather>) : RecyclerView.Adapter<WeatherAdapter.CardDesignWeatherHolder>() {
    inner class CardDesignWeatherHolder(binding: CardDesignWeatherBinding) : RecyclerView.ViewHolder(binding.root){
        var binding:CardDesignWeatherBinding
        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignWeatherHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding = CardDesignWeatherBinding.inflate(layoutInflater, parent, false)
        return CardDesignWeatherHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignWeatherHolder, position: Int) {
        val weather = weatherList.get(position)
        val w = holder.binding
        w.textViewDate.text = weather.date
        w.textViewDegree.text = weather.degree

    }

    override fun getItemCount(): Int {
        return weatherList.size
    }
}