package com.elhady.news.ui.newsList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.elhady.news.data.model.Article
import com.elhady.news.databinding.ItemNewsBinding

/**
 * Created by islam elhady on 23-Sep-21.
 */
class NewsAdapter() : ListAdapter<Article, NewsAdapter.NewsViewHolder>(DiffCallback) {

    /**
     * Callback for calculating the diff between two non-null items in a list.
     *
     * Used by ListAdapter to calculate the minimum number of changes between and old list and a new
     * list that's been passed to `submitList`.
     */
    companion object DiffCallback : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return newItem.author + newItem.title == oldItem.author + newItem.title
        }
    }

    /**
     * ViewHolder for Groups items. All work is done by data binding.
     */
    class NewsViewHolder(val viewDataBinding: ItemNewsBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {

        fun bind(article: Article) {
            viewDataBinding.article = article
            viewDataBinding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): NewsViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemNewsBinding.inflate(layoutInflater, parent, false)
                return NewsViewHolder(binding)
            }
        }
    }

    /**
     * Part of the RecyclerView adapter, called when RecyclerView needs a new [ViewHolder].
     *
     * A ViewHolder holds a view for the [RecyclerView] as well as providing additional information
     * to the RecyclerView such as where on the screen it was last drawn during scrolling.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder.from(parent)
    }

    /**
     * Part of the RecyclerView adapter, called when RecyclerView needs to show an item.
     *
     * The ViewHolder passed may be recycled, so make sure that this sets any properties that
     * may have been set previously.
     */
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.viewDataBinding.also {
            holder.bind(getItem(position))
        }
    }


}