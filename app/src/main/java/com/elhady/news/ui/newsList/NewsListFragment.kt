package com.elhady.news.ui.newsList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.elhady.news.databinding.NewsListFragmentBinding
import com.elhady.news.utils.State
import androidx.lifecycle.Observer
import com.elhady.news.utils.makeToast
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by islam elhady on 22-Sep-21.
 */
class NewsListFragment : Fragment() {


    private lateinit var binding: NewsListFragmentBinding
    private val viewModel: NewsListViewModel by viewModel()
    private var adapter: NewsAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = NewsListFragmentBinding.inflate(inflater)
        setupAdapter()
        setupObservers()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
        }
    }

    private fun setupAdapter() {
        adapter = NewsAdapter()
        // Sets the adapter of the RecyclerView
        binding.newsRecycler.adapter = adapter
        postponeEnterTransition()
        binding.newsRecycler.viewTreeObserver.addOnPreDrawListener {
            startPostponedEnterTransition()
            true
        }
    }


    private fun setupObservers() {
        viewModel.allArticlesLiveData.observe(viewLifecycleOwner, Observer { state ->
                when (state) {
                    is State.Loading -> binding.swipeRefresh.isRefreshing = true
                    is State.Success -> {
                        if (state.data.articles?.isNotEmpty()!!)
                            adapter?.submitList(state.data.articles)
                        else
                            makeToast("NO DATA")
                            binding.swipeRefresh.isRefreshing = false
                    }
                    is State.Error -> makeToast("No Internet")

                }
            })
    }

    override fun onResume() {
        super.onResume()
        viewModel.getArticles()
    }
}