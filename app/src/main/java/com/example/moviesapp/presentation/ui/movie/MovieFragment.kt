package com.example.moviesapp.presentation.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentMovieBinding
import com.example.moviesapp.domain.model.Movie
import com.example.moviesapp.presentation.ui.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment: Fragment() {

    private var _binding: FragmentMovieBinding? = null
    private val binding: FragmentMovieBinding get() = _binding!!

    private val viewModel: MovieViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        initView()
        initListener()
        initObservers()
        return binding.root
    }

    private fun initListener() {
        binding.iFpPages.apply {
            imCpLeft.setOnClickListener {
                viewModel.previousPage()
            }
            imCpRight.setOnClickListener {
                viewModel.nextPage()
            }
        }
    }

    private fun initView() {
        binding.rvFpCoinList.layoutManager = LinearLayoutManager(context)
    }

    private fun initObservers() {
        binding.apply {
            viewModel.listMovies.observe(viewLifecycleOwner){ list ->
                val movieAdapter = MovieAdapter(object: OnItemClick{
                    override fun onClick(item: Movie) {
                        viewModel.setMovie(item)
                        findNavController().navigate(R.id.action_movie_to_movie_detail)
                    }
                })
                movieAdapter.submitList(list)
                rvFpCoinList.adapter = movieAdapter
            }
            viewModel.page.observe(viewLifecycleOwner){ page ->
                tvFmdTittle.text = "pagina ${page}"
                iFpPages.tvCpPageNum.text = page.toString()
                if (page.equals(1)){
                    iFpPages.imCpLeft.visibility = View.GONE
                } else{
                    iFpPages.imCpLeft.visibility = View.VISIBLE
                }
            }
        }
    }

}