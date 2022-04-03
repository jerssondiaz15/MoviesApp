package com.example.moviesapp.data.movie.remote.network

import com.example.moviesapp.data.movie.remote.model.ListMovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieService @Inject constructor(
    private val api: MovieApiClient
) {

    suspend fun getListMovies(): ListMovieResponse? {
        return withContext(Dispatchers.IO){
            val response = api.getListMovies()
            response.body()
        }
    }
}