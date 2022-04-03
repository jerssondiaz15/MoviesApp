package com.example.moviesapp.data.movie.local

import com.example.moviesapp.data.movie.local.datasource.MovieDatabaseDataSource
import com.example.moviesapp.data.movie.local.model.mapper.toDbMovie
import com.example.moviesapp.data.movie.local.model.mapper.toListMovie
import com.example.moviesapp.domain.model.Movie
import com.example.moviesapp.domain.repository.IMovieRepository
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieDatabaseDataSource: MovieDatabaseDataSource
): IMovieRepository {

    override suspend fun getListMovie(): List<Movie> {
        return movieDatabaseDataSource.getListDbMovie().toListMovie()
    }

    override suspend fun deleteAllMovies() {
        movieDatabaseDataSource.deleteAllMovies()
    }

    override suspend fun insertMovies(movie: Movie) {
        movieDatabaseDataSource.insertMovies(movie.toDbMovie())
    }

}