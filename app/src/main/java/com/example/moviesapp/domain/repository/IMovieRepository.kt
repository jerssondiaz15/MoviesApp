package com.example.moviesapp.domain.repository

import com.example.moviesapp.domain.model.Movie


interface IMovieRepository {

    suspend fun getListMovie(): List<Movie>
    suspend fun deleteAllMovies()
    suspend fun insertMovies(movie: Movie)

}