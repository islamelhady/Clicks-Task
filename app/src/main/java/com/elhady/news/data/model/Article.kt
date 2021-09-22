package com.elhady.news.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by islam elhady on 22-Sep-21.
 */
@Parcelize
data class Article(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
): Parcelable

@Parcelize
data class Source(
    val id: String?,
    val name: String
): Parcelable