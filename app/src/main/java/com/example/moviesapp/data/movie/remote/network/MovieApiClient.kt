package com.example.moviesapp.data.movie.remote.network

import com.example.moviesapp.data.movie.remote.model.ListMovieResponse
import retrofit2.Response
import retrofit2.http.GET

interface MovieApiClient {
    @GET("upcoming?page=2&api_key=f46b58478f489737ad5a4651a4b25079")
    suspend fun getListMovies(): Response<ListMovieResponse>
}