package com.example.moviesapp.usecases

import com.example.moviesapp.data.movie.remote.MovieRemoteRepository
import com.example.moviesapp.domain.model.Movie
import com.example.moviesapp.domain.repository.IMovieRepository
import com.example.moviesapp.domain.test.Data.listMovies
import com.example.moviesapp.domain.usecase.GetListMoviesUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetListMoviesUseCaseTest {

    @RelaxedMockK
    private lateinit var iMovieRepository: IMovieRepository

    @RelaxedMockK
    private lateinit var repository: MovieRemoteRepository

    lateinit var getListMoviesUseCase: GetListMoviesUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getListMoviesUseCase = GetListMoviesUseCase(iMovieRepository, repository)
    }

    @Test
    fun `when the api return the movie data from api`() = runBlocking {
        //Given
        val data: List<Movie> = listMovies
        coEvery { repository.getListMovies(PAGE) } returns data

        //When
        val response = getListMoviesUseCase.invoke(PAGE)

        //Then
        coVerify(exactly = 1) { repository.getListMovies(PAGE) }
        assert(response == data)
    }

    @Test
    fun `when the api return the movie data from database`() = runBlocking {
        //Given
        val data: List<Movie> = listMovies
        coEvery { iMovieRepository.getListMovie() } returns data

        //When
        val response = getListMoviesUseCase.invoke(PAGE)

        //Then
        coVerify(exactly = 1) { iMovieRepository.getListMovie() }
        assert(response == data)
    }
}

const val PAGE = 1