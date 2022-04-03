package com.example.moviesapp.data.movie.local.model.mapper

import com.example.moviesapp.data.movie.local.model.DbMovie
import com.example.moviesapp.domain.model.Movie

fun List<DbMovie>.toListMovie(): List<Movie> = this.map { it.toMovie() }
fun DbMovie.toMovie(): Movie = with(this){
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

fun List<Movie>.toDbMovie(): List<DbMovie> = this.map { it.toDbMovie() }
fun Movie.toDbMovie(): DbMovie = with(this){
    DbMovie(
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