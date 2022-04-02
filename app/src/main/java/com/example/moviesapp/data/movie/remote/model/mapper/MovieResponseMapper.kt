package com.example.moviesapp.data.movie.remote.model.mapper

import com.example.moviesapp.data.movie.remote.model.MovieResponse
import com.example.moviesapp.domain.model.Movie

fun List<MovieResponse>.toListMovie(): List<Movie> = this.map { it.toMovie() }
fun MovieResponse.toMovie(): Movie = with(this){
    Movie(
        id = id,
        backdropPath = backdropPath,
        originalLanguage = originalLanguage,
        coin = coin,
        synopsis = synopsis,
        posterPath = posterPath,
        releaseDate = releaseDate,
        title = title,
        voteAverage = voteAverage
    )
}