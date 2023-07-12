package com.example.quotes


import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("/v1/covid?q=covid&lang=en&media=True")
    fun getNews(): Call<NewsList>

}