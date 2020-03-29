package com.codekinian.themovieapps.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.codekinian.themovieapps.model.data.Movie
import com.codekinian.themovieapps.model.data.Tvshow
import com.codekinian.themovieapps.model.data.movies.NowPlaying
import com.codekinian.themovieapps.model.data.movies.PopularMovie
import com.codekinian.themovieapps.model.data.movies.Upcoming
import com.codekinian.themovieapps.model.data.tvshows.AiringToday
import com.codekinian.themovieapps.model.data.tvshows.OnTheAir
import com.codekinian.themovieapps.model.data.tvshows.PopularTv

@Database(
    entities = [NowPlaying::class, PopularMovie::class, Upcoming::class,
        AiringToday::class, PopularTv::class, OnTheAir::class,
        Movie::class, Tvshow::class],
    version = 1,
    exportSchema = false
)
abstract class TheMovieDatabase : RoomDatabase() {
    abstract fun theMovieDao(): TheMovieDao
    abstract fun theTvDao(): TheTvDao

    companion object {

        @Volatile
        private var INSTANCE: TheMovieDatabase? = null

        fun getInstance(context: Context): TheMovieDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    TheMovieDatabase::class.java,
                    "MovieTvApp.db"
                ).build()
            }
    }
}