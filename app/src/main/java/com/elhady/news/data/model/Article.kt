package com.elhady.news.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by islam elhady on 22-Sep-21.
 */
@Parcelize
data class Article(
    val author: String? = null,
    val content: String? = null,
    val description: String? = null,
    val publishedAt: String? = null,
    val source: Source? = null,
    val title: String? = null,
    val url: String? = null,
    val urlToImage: String? = null
): Parcelable

@Parcelize
data class Source(
    val id: String?,
    val name: String
): Parcelable