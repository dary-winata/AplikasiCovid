package com.example.aplikasidisastercheck.model.retrofit

import com.example.aplikasidisastercheck.global.globalString
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GeneralRetrofit {
    private fun getRetrofit(url: String): Retrofit {
        return  Retrofit.Builder().
        baseUrl(url).
        addConverterFactory(GsonConverterFactory.create()).
        build()
    }

    fun NewsCovid() = getRetrofit(globalString.BASE_URL_NEWS)
        .create(com.example.aplikasidisastercheck.NewsCovid::class.java)

    fun FaskesCovid() = getRetrofit(globalString.BASE_URL_COVID_INDONESIA)
        .create(com.example.aplikasidisastercheck.FaskesCovid::class.java)
}
