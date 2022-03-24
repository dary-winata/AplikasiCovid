package com.example.aplikasidisastercheck.model.retrofit

import retrofit2.http.GET
import retrofit2.http.Path

interface FaskesCovidApiEndpoint {
    @GET("get-faskes-vaksinasi/?city={url}")
    suspend fun getDataFaskes(@Path(value = "url", encoded = true) url: String)
}