package com.example.moviesapp.data.movie.remote.network

import com.example.moviesapp.data.movie.remote.model.ListMovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieService @Inject constructor(
    private val api: MovieApiClient
) {

    suspend fun getListMovies(nextPage: Int): ListMovieResponse? {
        return withContext(Dispatchers.IO){
            val response = api.getListMovies(nextPage, API_KEY)
            response.body()
        }
    }
}

const val API_KEY = "f46b58478f489737ad5a4651a4b25079"