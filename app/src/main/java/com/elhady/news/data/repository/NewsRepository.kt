package com.elhady.news.data.repository

import com.elhady.news.data.model.NewsResponse
import com.elhady.news.data.remote.ApiService
import com.elhady.news.utils.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

/**
 * Created by islam elhady on 22-Sep-21.
 */
class NewsRepository(private val apiService: ApiService) {

    fun getAllArticles(): Flow<State<NewsResponse>> {
        return object : NetworkBoundRepository<NewsResponse>() {
            override suspend fun fetchFromRemote(): Response<NewsResponse> =
                apiService.getAllArticles("eg", "63b1f94dad044add871d1e319c630265")
        }.asFlow().flowOn(Dispatchers.IO)
    }
}