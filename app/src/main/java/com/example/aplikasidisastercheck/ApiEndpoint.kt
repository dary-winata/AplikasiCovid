package com.example.aplikasidisastercheck

import retrofit2.http.GET
import retrofit2.Call

interface ApiEndpoint {
    @GET("?city=Surabaya")
    fun getDataCity(): Call<List<InfoFaskes>>
}