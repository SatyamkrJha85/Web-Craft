package com.theapplication.webcraft.Mvvm.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ProductInstance {
    private const val Baseurl="https://64bfc2a60d8e251fd111630f.mockapi.io/api/"

    private fun getinstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val productApi:ProductApi= getinstance().create(ProductApi::class.java)
}