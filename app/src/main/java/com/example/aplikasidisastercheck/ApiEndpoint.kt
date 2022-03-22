package com.example.aplikasidisastercheck

import retrofit2.http.GET
import retrofit2.Call

interface FaskesCovid {
    @GET("get-faskes-vaksinasi/?city={globalString.user_state}")
    fun getDataFaskesCity(): Call<InfoFaskes>
}

interface NewsCovid {
    @GET( "top-headlines?country=id&category=health&apiKey=4165fb8a96de47e0a6c6e80b6fdc6c24")
    fun getNewsHealthIndonesia(): Call<News>
}