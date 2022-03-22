package com.example.aplikasidisastercheck

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class NetworkConfig {
    private fun getRetrofit(): Retrofit {
        return  Retrofit.Builder().
        baseUrl(globalString.BASE_URL_NEWS).
        addConverterFactory(GsonConverterFactory.create()).
        build()
    }

    fun NewsCovid() = getRetrofit().create(NewsCovid::class.java)
    fun FaskesCovid() = getRetrofit().create(FaskesCovid::class.java)
}