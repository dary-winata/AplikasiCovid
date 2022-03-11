package com.example.aplikasidisastercheck

import retrofit2.http.GET
import retrofit2.Call

//interface ApiEndpoint {
//    @GET("get-faskes-vaksinasi/?city=Surabaya")
//    fun getDataCity(): Call<InfoFaskes>
//}

interface getNews {
    @GET( "top-headlines?country=id&category=health&apiKey=4165fb8a96de47e0a6c6e80b6fdc6c24")
    fun getNewsHealthIndonesia(): Call<News>
}