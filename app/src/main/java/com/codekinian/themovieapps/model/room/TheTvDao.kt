package com.codekinian.themovieapps.model.room

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.room.*
import com.codekinian.themovieapps.model.data.Tvshow
import com.codekinian.themovieapps.model.data.tvshows.AiringToday
import com.codekinian.themovieapps.model.data.tvshows.OnTheAir
import com.codekinian.themovieapps.model.data.tvshows.PopularTv

@Dao
interface TheTvDao {

    @Query("SELECT * FROM airing_today")
    fun getAiringToday(): LiveData<List<AiringToday>>

    @Query("SELECT * FROM on_the_air")
    fun getOnTheAir(): LiveData<List<OnTheAir>>

    @Query("SELECT * FROM popular_tv")
    fun getPopularTv(): LiveData<List<PopularTv>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAiringToday(airingTodays: List<AiringToday>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOnTheAir(onTheAirs: List<OnTheAir>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPopular(popularTvs: List<PopularTv>)

    @Query("SELECT * FROM airing_today WHERE id = :id")
    fun getAiringTodayById(id: Int): LiveData<Tvshow>

    @Query("SELECT * FROM on_the_air WHERE id = :id")
    fun getOnTheAirById(id: Int): LiveData<Tvshow>

    @Query("SELECT * FROM popular_tv WHERE id = :id")
    fun getPopularTvById(id: Int): LiveData<Tvshow>

    // Favorite Dao
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertDetailTvShow(tvshow: Tvshow)

    @Transaction
    @Query("SELECT * FROM tvshow_tb WHERE id = :id")
    fun getTvShowById(id: Int): LiveData<Tvshow>

    @WorkerThread
    @Query("SELECT * FROM tvshow_tb where isFavorite = 1")
    fun getTvShows(): LiveData<List<Tvshow>>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateTvShow(movie: Tvshow): Int

}
