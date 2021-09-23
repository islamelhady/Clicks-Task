package com.elhady.news.data.remote

import com.elhady.news.data.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by islam elhady on 22-Sep-21.
 */
interface ApiService {

    @GET("top-headlines")
    suspend fun getAllArticles(
        @Query("country") country: String, @Query("apiKey") apiKey: String?
    ): Response<NewsResponse>

    companion object {
        const val BASE_URL = "https://newsapi.org/v2/"
    }
}

