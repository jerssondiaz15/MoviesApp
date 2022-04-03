package com.example.moviesapp.presentation.ui.moviedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.moviesapp.databinding.FragmentMovieDetailBinding
import com.example.moviesapp.presentation.ui.MovieViewModel
import com.example.moviesapp.presentation.ui.movie.URL
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment: Fragment() {

    private var _binding: FragmentMovieDetailBinding? = null
    private val binding: FragmentMovieDetailBinding get() = _binding!!

    private val viewModel: MovieViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        initObservers()
        return binding.root
    }

    private fun initObservers() {
        binding.apply {
            viewModel.movie.observe(viewLifecycleOwner){ movie ->
                tvFmdTittle.text = movie.title
                tvFmdReleaseDate.text = movie.releaseDate
                ivFmdImage.load(URL + movie.posterPath)
                rbFmdVoteAverage.rating = movie.voteAverage!!.toFloat()
                tvFmdSynopsis.text = movie.synopsis
            }
        }
    }
}