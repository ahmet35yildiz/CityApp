package com.example.cityapp.retrofit

import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {

        private val client = OkHttpClient.Builder().addInterceptor { chain ->
            val request: Request = chain.request()
                .newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("authorization", "apikey 4MigEyBEiK9Gmr3D70yOS1:3W93MRZQ4oCrKGo7kC3RCr")
                .build()
            chain.proceed(request)
        }.build()

        fun getClient(baseUrl: String): Retrofit {
            return Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}