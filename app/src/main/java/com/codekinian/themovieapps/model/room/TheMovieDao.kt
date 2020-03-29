package com.codekinian.themovieapps.model.room

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.room.*
import com.codekinian.themovieapps.model.data.Movie
import com.codekinian.themovieapps.model.data.movies.NowPlaying
import com.codekinian.themovieapps.model.data.movies.PopularMovie
import com.codekinian.themovieapps.model.data.movies.Upcoming

@Dao
interface TheMovieDao {

    @Query("SELECT * FROM now_playing")
    fun getNowPlaying(): LiveData<List<NowPlaying>>

    @Query("SELECT * FROM popular_movie")
    fun getPopularMovie(): LiveData<List<PopularMovie>>

    @Query("SELECT * FROM upcoming")
    fun getUpcoming(): LiveData<List<Upcoming>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNowPlaying(nowPlayings: List<NowPlaying>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPopularMovie(popularMovies: List<PopularMovie>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUpcoming(upcomings: List<Upcoming>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: Movie)

    @Query("SELECT * FROM now_playing WHERE id = :id")
    fun getNowPlayingById(id: Int): LiveData<Movie>

    @Query("SELECT * FROM popular_movie WHERE id = :id")
    fun getPopularMovieById(id: Int): LiveData<Movie>

    @Query("SELECT * FROM upcoming WHERE id = :id")
    fun getUpcomingById(id: Int): LiveData<Movie>

    // Favorite Dao
    @Transaction
    @Query("SELECT * FROM movie_tb WHERE id = :id")
    fun getFavoriteMovieById(id: Int): LiveData<Movie>

    @WorkerThread
    @Query("SELECT * FROM movie_tb where isFavorite = 1")
    fun getFavoriteMovies(): LiveData<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavoriteMovies(movies: List<Movie>): LongArray

    @Update(onConflict = OnConflictStrategy.ABORT)
    fun updateFavoriteMovie(movie: Movie): Int

}