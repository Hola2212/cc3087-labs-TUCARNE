package com.example.lab05composefeed.model

data class Article(
    val name: String,
    val title: String,
    val summary: String,
    val readTime: Int,
    val date: String,
    val circleColor: Long,
    val squareColor: Long,
    val isAuthorFollowed: Boolean,
    val isFeatured: Boolean
)
