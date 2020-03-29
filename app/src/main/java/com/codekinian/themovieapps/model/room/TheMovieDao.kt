package com.codekinian.themovieapps.model.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codekinian.themovieapps.model.data.Movie
import com.codekinian.themovieapps.model.data.Tvshow

@Dao
interface TheMovieDao {

    @Query("SELECT * FROM movie_tb")
    fun getMovies(): LiveData<List<Movie>>

    @Transaction
    @Query("SELECT * FROM movie_tb WHERE id = :id")
    fun getMovieById(id: String): LiveData<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<Movie>)

    @Update
    fun updateMovie(movie: Movie)

    @Query("SELECT * FROM tvshow_tb")
    fun getTvShows(): LiveData<List<Tvshow>>

    @Transaction
    @Query("SELECT * FROM tvshow_tb WHERE id = :id")
    fun getTvById(id: String): LiveData<Tvshow>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(movies: List<Tvshow>)

    @Update
    fun updateTvShow(tvshow: Tvshow)

}