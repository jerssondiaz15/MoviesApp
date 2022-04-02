package com.example.moviesapp.data.movie.remote.model

import com.google.gson.annotations.SerializedName

data class ListMovieResponse(
    @SerializedName("results") val listMovies: List<MovieResponse>,
)

data class MovieResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("backdrop_path") val backdropPath: String,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("original_title") val coin: String,
    @SerializedName("overview") val synopsis: String,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("title") val title: String,
    @SerializedName("vote_average") val voteAverage: Double
)