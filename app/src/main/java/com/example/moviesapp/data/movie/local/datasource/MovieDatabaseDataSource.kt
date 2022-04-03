package com.example.moviesapp.data.movie.local.datasource

import com.example.moviesapp.data.movie.local.MovieDataBase
import com.example.moviesapp.data.movie.local.model.DbMovie

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