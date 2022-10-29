package com.example.cityapp.data.entity

import com.google.gson.annotations.SerializedName

data class PharmacyInfoResponse(
    @SerializedName("success") var success: Boolean,
    @SerializedName("result") var resultPharmacy: List<PharmacyInfo>
)