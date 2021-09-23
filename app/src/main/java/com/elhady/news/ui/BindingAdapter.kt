package com.elhady.news.ui

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.elhady.news.R
import com.makeramen.roundedimageview.RoundedImageView

/**
 * Created by islam elhady on 23-Sep-21.
 */
@BindingAdapter("loadImage")
fun loadImage(view: AppCompatImageView, url: String?) {
    if (!url.isNullOrEmpty())
        Glide.with(view.context)
            .load(url)
            .apply(
                RequestOptions()
                    .error(R.drawable.placeholder)
            )
            .into(view)
}
@BindingAdapter("loadImageCircle")
fun loadImage(view: RoundedImageView, url: String?) {
    if (!url.isNullOrEmpty())
        Glide.with(view.context)
            .load(url)
            .apply(
                RequestOptions()
                    .error(R.drawable.placeholder)
            )
            .into(view)
}
