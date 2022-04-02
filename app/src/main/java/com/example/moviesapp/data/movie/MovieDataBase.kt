package com.example.moviesapp.data.movie

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviesapp.data.movie.dao.MovieDao
import com.example.moviesapp.data.movie.model.DbMovie

@Database(
    entities = [
        DbMovie::class
    ],
    version = 1
)
abstract class MovieDataBase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
}