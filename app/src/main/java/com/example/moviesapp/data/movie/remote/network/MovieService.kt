package com.example.moviesapp.data.movie.remote.network

import com.example.moviesapp.data.core.RetrofitHelper
import com.example.moviesapp.data.movie.remote.model.ListMovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getListMovies(): ListMovieResponse? {
        return withContext(Dispatchers.IO){
            val response = retrofit.create(MovieApiClient::class.java).getListMovies()
            response.body()
        }
    }
}