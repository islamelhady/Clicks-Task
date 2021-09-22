package com.elhady.news.ui.newsList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.elhady.news.databinding.NewsListFragmentBinding

/**
 * Created by islam elhady on 22-Sep-21.
 */
class NewsListFragment : Fragment() {


    private lateinit var binding: NewsListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = NewsListFragmentBinding.inflate(inflater)
        return binding.root
    }


}