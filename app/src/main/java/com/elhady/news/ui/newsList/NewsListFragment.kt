package com.elhady.news.ui.newsList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import com.elhady.news.databinding.NewsListFragmentBinding
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.elhady.news.data.model.Article
import com.elhady.news.utils.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*

/**
 * Created by islam elhady on 22-Sep-21.
 */
class NewsListFragment : Fragment() {


    private lateinit var binding: NewsListFragmentBinding
    private val viewModel: NewsListViewModel by viewModel()
    private var adapter: NewsAdapter? = null
    private var newsList = mutableListOf<Article>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = NewsListFragmentBinding.inflate(inflater)
        setupAdapter()
        setupObservers()
        binding.swipeRefresh.setOnRefreshListener { refreshAllArticles() }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
        }
        handleSearchMechanism()
    }


    private fun handleSearchMechanism() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                return if (!query.isNullOrBlank()) {
                    filter(query)
                    false
                } else {
                    refreshAllArticles()
                    true
                }
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return if (!newText.isNullOrBlank()) {
                    filter(newText)
                    false
                } else {
                    refreshAllArticles()
                    true
                }
            }

        })
    }

    private fun populateFullList() {
        adapter?.submitList(newsList)
    }

    private fun filter(text: String) {
        val filteredList: ArrayList<Article> = ArrayList()
        for (item in newsList) {
            if (item.title?.toLowerCase(Locale.ROOT)
                    ?.contains(text.toLowerCase(Locale.ROOT)) == true
            ) {
                filteredList.add(item)
            }
        }
        adapter?.submitList(filteredList.toMutableList())
    }


    private fun setupAdapter() {
        adapter = NewsAdapter(NewsItemClick { it ->
            val toDetailsFragment = it.let {
                NewsListFragmentDirections.actionNewsListFragmentToDetailsFragment(it)
            }
            findNavController().navigate(toDetailsFragment)
        })
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
                is State.Error -> {
                    binding.swipeRefresh.isRefreshing = false
                    makeToast(state.message)
                }
            }
        })
    }

    override fun onResume() {
        super.onResume()
        refreshAllArticles()
    }

    private fun refreshAllArticles() {
        viewModel.getArticles()
    }
}