package com.example.aplikasidisastercheck

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkConfig {
    fun getRetrofit(): Retrofit {
        return  Retrofit.Builder().
        baseUrl(globalString.BASE_URL).
        addConverterFactory(GsonConverterFactory.create()).
        build()
    }

    fun getService() = getRetrofit().create(ApiEndpoint::class.java)
}