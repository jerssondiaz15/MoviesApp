package com.example.moviesapp.data.movie.remote

import com.example.moviesapp.data.movie.remote.model.mapper.toListMovie
import com.example.moviesapp.data.movie.remote.network.MovieService
import com.example.moviesapp.domain.model.Movie
import javax.inject.Inject

class MovieRemoteRepository @Inject constructor(
    private val api: MovieService
) {

    suspend fun getListMovies(): List<Movie>? {
        val response = api.getListMovies()
        return response?.listMovies?.toListMovie()
    }

}