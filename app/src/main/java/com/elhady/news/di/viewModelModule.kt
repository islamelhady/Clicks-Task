package com.elhady.news.di

import com.elhady.news.ui.newsList.NewsListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by islam elhady on 23-Sep-21.
 */
val viewModelModule = module {

    viewModel {
        NewsListViewModel(get())
    }
}