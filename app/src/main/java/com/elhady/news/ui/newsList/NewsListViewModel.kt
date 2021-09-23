package com.elhady.news.ui.newsList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elhady.news.data.model.NewsResponse
import com.elhady.news.data.repository.NewsRepository
import com.elhady.news.utils.State
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect

/**
 * Created by islam elhady on 22-Sep-21.
 */
class NewsListViewModel(val repository: NewsRepository) : ViewModel() {

    private val _allArticlesLiveData = MutableLiveData<State<NewsResponse>>()
    val allArticlesLiveData: LiveData<State<NewsResponse>>
        get() = _allArticlesLiveData

    fun getArticles() {
        viewModelScope.launch {
            repository.getAllArticles().collect {
                _allArticlesLiveData.value = it
            }
        }
    }
}