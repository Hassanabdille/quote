package com.example.quotes

data class News(
    val _id: String,
    val _score: Double,
    val author: String,
    val clean_url: String,
    val country: String,
    val language: String,
    val link: String,
    val media: String,
    val media_content: List<String>,
    val published_date: String,
    val rank: Int,
    val rights: String,
    val summary: String,
    val title: String,
    val topic: String
)