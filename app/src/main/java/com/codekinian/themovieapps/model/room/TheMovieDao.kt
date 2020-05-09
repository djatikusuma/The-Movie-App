package com.codekinian.themovieapps.model.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.codekinian.themovieapps.model.data.Movie
import com.codekinian.themovieapps.model.data.movies.NowPlaying
import com.codekinian.themovieapps.model.data.movies.PopularMovie
import com.codekinian.themovieapps.model.data.movies.Upcoming

@Dao
interface TheMovieDao {

    @Query("SELECT * FROM now_playing")
    fun getNowPlaying(): DataSource.Factory<Int, NowPlaying>

    @Query("SELECT * FROM popular_movie")
    fun getPopularMovie(): DataSource.Factory<Int, PopularMovie>

    @Query("SELECT * FROM upcoming")
    fun getUpcoming(): DataSource.Factory<Int, Upcoming>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNowPlaying(nowPlayings: List<NowPlaying>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPopularMovie(popularMovies: List<PopularMovie>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUpcoming(upcomings: List<Upcoming>)

    @Query("SELECT * FROM now_playing WHERE id = :id")
    fun getNowPlayingById(id: Int): LiveData<Movie>

    @Query("SELECT * FROM popular_movie WHERE id = :id")
    fun getPopularMovieById(id: Int): LiveData<Movie>

    @Query("SELECT * FROM upcoming WHERE id = :id")
    fun getUpcomingById(id: Int): LiveData<Movie>

    // Favorite Dao
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertDetailMovie(movie: Movie)

    @Transaction
    @Query("SELECT * FROM movie_tb WHERE id = :id")
    fun getMovieById(id: Int): LiveData<Movie>

    @Query("SELECT * FROM movie_tb where isFavorite = 1")
    fun getMovies(): DataSource.Factory<Int, Movie>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateMovie(movie: Movie): Int

}