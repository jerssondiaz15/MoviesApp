package com.example.moviesapp.data.movie.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "movie_table"
)
data class DbMovie(
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "backdropPath") val backdropPath: String,
    @ColumnInfo(name = "originalLanguage") val originalLanguage: String,
    @ColumnInfo(name = "originalTitle") val coin: String,
    @ColumnInfo(name = "synopsis") val synopsis: String,
    @ColumnInfo(name = "posterPath") val posterPath: String,
    @ColumnInfo(name = "releaseDate") val releaseDate: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "voteAverage") val voteAverage: Double,
)