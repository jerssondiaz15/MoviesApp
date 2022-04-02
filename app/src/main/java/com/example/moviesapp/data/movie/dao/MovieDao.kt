package com.example.moviesapp.data.movie.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviesapp.data.movie.model.DbMovie

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_table")
    suspend fun getListDbMovie(): List<DbMovie>

    @Query("DELETE FROM movie_table")
    suspend fun deleteAllMovies()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMovies(dbMovie: DbMovie)

}