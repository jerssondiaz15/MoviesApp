package com.example.moviesapp.domain.model

data class Movie(
    val id: Int,
    val backdropPath: String? = "",
    val originalLanguage: String? = "",
    val coin: String? = "",
    val synopsis: String? = "",
    val posterPath: String? = "",
    val releaseDate: String? = "",
    val title: String? = "",
    val voteAverage: Double? = 0.0
)