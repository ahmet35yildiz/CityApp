package com.example.cityapp.data.entity

import com.google.gson.annotations.SerializedName

data class NewsInfoResponse(
    @SerializedName("success") var success: Boolean,
    @SerializedName("result") var resultNews: List<NewsInfo>
)