package com.example.moviesapp.domain.usecase

import com.example.moviesapp.domain.repository.IMovieRepository
import javax.inject.Inject

class DeleteAllMoviesUseCase @Inject constructor(
    private val iMovieRepository: IMovieRepository
) {

    suspend operator fun invoke(){
        iMovieRepository.deleteAllMovies()
    }

}