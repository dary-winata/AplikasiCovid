package com.example.aplikasidisastercheck

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkConfig {
    fun getRetrofit(): Retrofit {
        return  Retrofit.Builder().
        baseUrl(globalString.BASE_URL_NEWS).
        addConverterFactory(GsonConverterFactory.create()).
        build()
    }

    fun getService() = getRetrofit().create(getNews::class.java)
}