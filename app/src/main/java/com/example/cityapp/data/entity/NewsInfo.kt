package com.example.cityapp.data.entity

import com.google.gson.annotations.SerializedName

data class NewsInfo(
    @SerializedName("key") var newsKey: String?,
    @SerializedName("url") var newsUrl: String?,
    @SerializedName("description") var newsDescription: String?,
    @SerializedName("image") var newsImage: String?,
    @SerializedName("name") var newsName: String?,
    @SerializedName("source") var newsSource: String?,
    @SerializedName("date") var newsDate: String?
)