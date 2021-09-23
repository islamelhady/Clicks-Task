package com.elhady.news.ui

import android.text.method.LinkMovementMethod
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.elhady.news.R

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

@BindingAdapter("descriptionHtml")
fun bindDescriptionHtml(view: AppCompatTextView, description: String?) {
    if (description != null) {
        view.text = HtmlCompat.fromHtml(description, HtmlCompat.FROM_HTML_MODE_COMPACT)
        view.movementMethod = LinkMovementMethod.getInstance()
    } else {
        view.text = ""
    }
}
