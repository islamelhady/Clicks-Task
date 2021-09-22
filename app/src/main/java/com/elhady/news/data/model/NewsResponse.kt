package com.elhady.news.data.model

/**
 * Created by islam elhady on 22-Sep-21.
 */
data class NewsResponse(
    val articles: List<Article>?,
    val status: String,
    val totalResults: Int
)