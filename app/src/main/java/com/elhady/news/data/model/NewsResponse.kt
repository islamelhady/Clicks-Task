package com.elhady.news.data.model

/**
 * Created by islam elhady on 22-Sep-21.
 */
data class NewsResponse(
    val articles: List<Article>? = null,
    val status: String,
    val totalResults: Int
)