package com.example.moviesapp.data.di

import android.content.Context
import androidx.room.Room
import com.example.moviesapp.data.movie.MovieDataBase
import com.example.moviesapp.data.movie.MovieRepository
import com.example.moviesapp.data.movie.datasource.MovieDatabaseDataSource
import com.example.moviesapp.domain.repository.IMovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    private const val MOVIE_DATABASE_NAME = "movie_database"

    @Provides
    @Singleton
    fun provideCoinDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, MovieDataBase::class.java, MOVIE_DATABASE_NAME)
            .build()

    @Provides
    @Singleton
    fun provideMovieDao(db: MovieDataBase) = db.movieDao()

    @Provides
    fun provideMovieRepository(
        movieDatabaseDataSource: MovieDatabaseDataSource
    ): IMovieRepository{
        return MovieRepository(
            movieDatabaseDataSource = movieDatabaseDataSource
        )
    }

    @Provides
    fun provideMovieDatabaseDataSource(
        movieDataBase: MovieDataBase
    ): MovieDatabaseDataSource{
        return MovieDatabaseDataSource(
            movieDataBase = movieDataBase
        )
    }

}