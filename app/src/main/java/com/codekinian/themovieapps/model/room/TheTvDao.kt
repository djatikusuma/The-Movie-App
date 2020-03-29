package com.codekinian.themovieapps.model.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codekinian.themovieapps.model.data.Tvshow

@Dao
interface TheTvDao {

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
