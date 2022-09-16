package com.example.cityapp.ui.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cityapp.R
import com.example.cityapp.databinding.CardDesignWeatherBinding
import com.example.cityapp.data.entity.WeatherInfo

class WeatherAdapter(var weatherList:List<WeatherInfo>)
    : RecyclerView.Adapter<WeatherAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(binding: CardDesignWeatherBinding) : RecyclerView.ViewHolder(binding.root)  {  //card_design_weather' a erişmek için gerekli olan sınıf
        var binding: CardDesignWeatherBinding
        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding:CardDesignWeatherBinding = DataBindingUtil.inflate(layoutInflater,R.layout.card_design_weather,parent,false)
        return CardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val weather = weatherList[position]

        holder.binding.weatherObject = weather
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }
}