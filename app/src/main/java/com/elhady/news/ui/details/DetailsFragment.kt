package com.elhady.news.ui.details

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.elhady.news.R
import com.elhady.news.databinding.DetailsFragmentBinding

/**
 * Created by islam elhady on 22-Sep-21.
 */
class DetailsFragment : Fragment() {

    private lateinit var binding: DetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DetailsFragmentBinding.inflate(inflater)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.details_menu, menu)
    }

}