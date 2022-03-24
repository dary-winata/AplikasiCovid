package com.example.aplikasidisastercheck.model.retrofit

import com.example.aplikasidisastercheck.News
import retrofit2.Call
import retrofit2.http.GET

interface NewsApiEndpoint {
    @GET("top-headlines?country=id&category=health&apiKey=4165fb8a96de47e0a6c6e80b6fdc6c24")
    suspend fun getData(): Call<News>
}