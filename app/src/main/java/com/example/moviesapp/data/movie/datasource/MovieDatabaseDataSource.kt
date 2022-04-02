package com.example.moviesapp.data.movie.datasource

import com.example.moviesapp.data.movie.MovieDataBase
import com.example.moviesapp.data.movie.model.DbMovie

class MovieDatabaseDataSource(
    private val movieDataBase: MovieDataBase
) {

    suspend fun getListDbMovie(): List<DbMovie> {
        return movieDataBase.movieDao().getListDbMovie()
    }

    suspend fun deleteAllMovies(){
        movieDataBase.movieDao().deleteAllMovies()
    }

    suspend fun insertMovies(dbMovie: DbMovie){
        movieDataBase.movieDao().insertMovies(dbMovie)
    }

}