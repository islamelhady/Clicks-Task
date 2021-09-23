package com.elhady.news.ui.details

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.elhady.news.databinding.DetailsFragmentBinding

/**
 * Created by islam elhady on 22-Sep-21.
 */
class DetailsFragment : Fragment() {

    private lateinit var binding: DetailsFragmentBinding
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DetailsFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            article = args.article
            backBtn = this@DetailsFragment
        }
    }

    /**
     * Navigate to the apply screen to apply job .
     */
    fun goToNewsList() {
        binding.detailsIcBack.setOnClickListener { findNavController().navigateUp() }
    }
}