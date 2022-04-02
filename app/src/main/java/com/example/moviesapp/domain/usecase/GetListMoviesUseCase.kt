package com.example.moviesapp.domain.usecase

import com.example.moviesapp.domain.model.Movie
import com.example.moviesapp.domain.repository.IMovieRepository
import javax.inject.Inject

class GetListMoviesUseCase @Inject constructor(
    private val iMovieRepository: IMovieRepository
) {

    suspend operator fun invoke(): List<Movie>{
        return iMovieRepository.getListMovie()
    }

}