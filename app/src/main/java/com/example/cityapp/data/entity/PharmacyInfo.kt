package com.example.cityapp.data.entity

import com.google.gson.annotations.SerializedName

data class PharmacyInfo(
    @SerializedName("name") var pharmacyName: String?,
    @SerializedName("dist") var pharmacyDistrict: String?,
    @SerializedName("address") var pharmacyAddress: String?,
    @SerializedName("phone") var pharmacyPhone: String?,
    @SerializedName("loc") var pharmacyLocation: String?
)