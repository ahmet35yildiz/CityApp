package com.example.cityapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cityapp.R
import com.example.cityapp.data.entity.PharmacyInfo
import com.example.cityapp.databinding.CardDesignPharmacyBinding

class PharmacyAdapter(
    private var pharmacyList: List<PharmacyInfo>,
    private var onItemClick: (PharmacyInfo) -> Unit) :
    RecyclerView.Adapter<PharmacyAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(val binding: CardDesignPharmacyBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(pharmacy: PharmacyInfo) {

                with(binding) {
                    pharmacyObject = pharmacy //pharmacyObject, card_design_pharmacy.xml'deki değişken

                    buttonDirections.setOnClickListener { //Yol tarifi butonuna tıklandığında harita açılır
                        onItemClick(pharmacy)
                    }
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: CardDesignPharmacyBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.card_design_pharmacy, parent, false)
        return CardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) =
        holder.bind(pharmacyList[position])

    override fun getItemCount(): Int = pharmacyList.size
}