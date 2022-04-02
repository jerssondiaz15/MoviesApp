package com.example.moviesapp.domain.usecase

import com.example.moviesapp.data.movie.model.DbMovie
import com.example.moviesapp.domain.model.Movie
import com.example.moviesapp.domain.repository.IMovieRepository
import javax.inject.Inject

class InsertMovies @Inject constructor(
    private val iMovieRepository: IMovieRepository
) {

    suspend operator fun invoke(movie: Movie){
        iMovieRepository.insertMovies(movie)
    }

}