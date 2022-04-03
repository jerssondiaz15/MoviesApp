package com.example.moviesapp.data.movie.remote.network

import com.example.moviesapp.data.movie.remote.model.ListMovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiClient {

    @GET("upcoming")
    suspend fun getListMovies(
        @Query("page") id: Int,
        @Query("api_key") apiKey: String
    ): Response<ListMovieResponse>
}