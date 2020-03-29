package com.codekinian.themovieapps.model.room

import androidx.lifecycle.LiveData
import androidx.room.*
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

    @Update
    fun updateNowPlaying(nowPlaying: NowPlaying)

    @Update
    fun updatePopularMovie(popularMovie: PopularMovie)

    @Update
    fun updateUpcoming(upcoming: Upcoming)

}