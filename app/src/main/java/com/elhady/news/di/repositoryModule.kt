package com.elhady.news.di

import com.elhady.news.data.repository.NewsRepository
import org.koin.dsl.module

/**
 * Created by islam elhady on 23-Sep-21.
 */
val repositoryModule = module {

    single {
        NewsRepository(get())
    }
}