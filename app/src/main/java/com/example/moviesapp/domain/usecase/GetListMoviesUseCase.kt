package com.example.moviesapp.domain.usecase

import com.example.moviesapp.data.movie.remote.MovieRemoteRepository
import com.example.moviesapp.domain.model.Movie
import com.example.moviesapp.domain.repository.IMovieRepository
import javax.inject.Inject

class GetListMoviesUseCase @Inject constructor(
    private val iMovieRepository: IMovieRepository,
    private val repository: MovieRemoteRepository
) {

    suspend operator fun invoke(): List<Movie>?{

        val movie = repository.getListMovies()
        return if (movie!!.isNotEmpty()){
            iMovieRepository.deleteAllMovies()
            movie.map {
                iMovieRepository.insertMovies(it)
            }
            movie
        } else{
            iMovieRepository.getListMovie()
        }
    }

}