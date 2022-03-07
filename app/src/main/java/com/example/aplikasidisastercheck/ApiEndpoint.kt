package com.example.aplikasidisastercheck

import retrofit2.http.GET
import retrofit2.Call

interface ApiEndpoint {
    @GET("get-faskes-vaksinasi/?city=Surabaya")
    fun getDataCity(): Call<InfoFaskes>
}