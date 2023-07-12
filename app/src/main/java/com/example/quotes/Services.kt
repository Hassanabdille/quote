package com.example.quotes

import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Services {
//    val client = OkHttpClient()

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val originalRequest = chain.request()
            val modifiedRequest = addHeader(originalRequest)
            chain.proceed(modifiedRequest)
        }
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://covid-19-news.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    private fun addHeader(request: Request): Request {
        return request.newBuilder()
            .header("X-RapidAPI-Key", "7f66adeb0dmsh26787e5769dfffbp1dd26ajsn039b06160e84")
            .header("X-RapidAPI-Host", "covid-19-news.p.rapidapi.com")
            .build()
    }

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }
//    val request = Request.Builder()
//        .url("https://covid-19-news.p.rapidapi.com/v1/covid?q=covid&lang=en&page_size=50&media=True")
//        .get()
//        .addHeader("X-RapidAPI-Key", "7f66adeb0dmsh26787e5769dfffbp1dd26ajsn039b06160e84")
//        .addHeader("X-RapidAPI-Host", "covid-19-news.p.rapidapi.com")
//        .build()
//
//    val response = client.newCall(request).execute()
}