package com.example.moviesapp.presentation.ui.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.databinding.FragmentMovieBinding
import com.example.moviesapp.domain.model.Movie
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment: Fragment() {

    private var _binding: FragmentMovieBinding? = null
    private val binding: FragmentMovieBinding get() = _binding!!

    private val viewModel: MovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        initView()
        initObservers()
        return binding.root
    }

    private fun initView() {
        binding.rvFpCoinList.layoutManager = LinearLayoutManager(context)
    }

    private fun initObservers() {
        viewModel.listMovies.observe(viewLifecycleOwner){ list ->
            val movieAdapter = MovieAdapter(object: OnItemClick{
                override fun onClick(item: Movie) {
                    Log.i("Item: ", item.title)
                }
            })
            movieAdapter.submitList(list)
            binding.rvFpCoinList.adapter = movieAdapter
        }
    }

}